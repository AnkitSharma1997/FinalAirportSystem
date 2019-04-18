package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.entity.Hangar;
import com.cognizant.entity.HangarStatus;
import com.cognizant.exception.AllocationException;
import com.cognizant.exception.HangarNotFound;
import com.cognizant.exception.SessionExpired;
import com.cognizant.model.HangarModel;
import com.cognizant.model.HangarStatusModel;
import com.cognizant.service.HangarService;
import com.cognizant.service.PlaneService;

/**
 * 
 * @author 768817
 *
 *Hanger Controller will manage all the flow
 *
 */

@Controller
@SessionAttributes({"view1HangarModel", "hangarId", "managerId" , "view1HangarStatusModel"})
public class HangarController {

	@Autowired
	private HangarService hangarService;

	@Autowired
	private PlaneService planeService;

	@Autowired
	@Qualifier("hangarValidator")
	private Validator validator;

	private static final Logger logger = LoggerFactory.getLogger(HangarController.class);

	/*
	 * Display the hangerMain page if admin session is not expired
	 */
	
	@RequestMapping(value = "hangarMain.htm", method = RequestMethod.GET)
	public String loadHangarMain(HttpServletRequest request) {
		
		HttpSession session=request.getSession(false);	
		if(session.getAttribute("adminId")==null){
			throw new SessionExpired("Session Expired");
		}
		else
		{
			logger.info("----Loading Hangar Main Page in Hangar Controller----");
			return "hangarMain";
		}
	}


	/*
	 * Display hangerForm to take all the informations about hanger
	 */
	
	@RequestMapping(value = "hangarForm.htm", method = RequestMethod.GET)
	public String loadHangarForm() {
		logger.info("----Loading Add Hangar Form in Hangar Controller----");
		return "hangarForm";
	}

	/*
	 * Persist all the details of hanger in database
	 * 
	 */
	
	@RequestMapping(value = "addHangar.htm", method = RequestMethod.POST)
	public ModelAndView persistHangar(@ModelAttribute("hangarModel") HangarModel hangarModel, Errors errors) {

		ModelAndView mv=new ModelAndView();
		logger.info("----Add Hangar Form Submitted in Hangar Controller----");

		ValidationUtils.invokeValidator(validator, hangarModel , errors);
		ModelMap mapDummy=new ModelMap();
		if(errors.hasErrors())
		{
			logger.info("----Addition of Hangar Failed in Hangar Controller----");
			mv.setViewName("hangarForm");
			mapDummy.addAttribute("status", "Please update the highlighted mandatory field(s)");
		}
		else
		{
			boolean hangarPersist=hangarService.persistHangar(hangarModel);
			if(hangarPersist)
			{
				logger.info("----Addition of Hangar Successful in Hangar Controller----");
				mv.addObject("status", "Your details are submitted successfully");
				mapDummy.addAttribute("status", "Your details are submitted successfully");
			}
			else
			{
				logger.info("----Addition of Hangar Failed in Hangar Controller----");
				mv.addObject("status", "Please update the highlighted mandatory field(s)");			
				mapDummy.addAttribute("status", "Please update the highlighted mandatory field(s)");
			}
		}
		mv.setViewName("hangarForm");		
		return mv;
	}

	/*
	 * Display the viewHangars page to show how many hangers are there
	 */
	
	@RequestMapping(value = "viewHangars.htm", method = RequestMethod.GET)
	public ModelAndView viewHangars() {
		logger.info("----View All Hangars in Hangar Controller----");
		List<Hangar> hangarList = hangarService.getAllHangars();
		ModelAndView mv = new ModelAndView();
		mv.addObject("hangarList", hangarList);
		mv.setViewName("viewHangars");
		return mv;
	}


	/*
	 * Display viewOneHanger page
	 */
	
	@RequestMapping(value = "viewOneHangar.htm", method = RequestMethod.GET)
	public ModelAndView viewHangar(ModelMap map, @ModelAttribute("hangarmodel") HangarModel hangarModel,
		@RequestParam("hangarId") int hangar1) {
		logger.info("----View One Hangar Details in Hangar Controller----");
		ModelAndView mv = new ModelAndView();
		HangarModel view1HangarModel = hangarService.getHangar(hangar1);
		map.addAttribute("view1HangarModel", view1HangarModel);
		mv.setViewName("viewOneHangar");
		return mv;
	}

	/*
	 * Display viewHanger page to Update the Hangar details
	 */
	
	@RequestMapping(value = "editHangar.htm", method = RequestMethod.POST)
	public ModelAndView updateHangar(@ModelAttribute("view1HangarModel") HangarModel hangarModel, Errors errors) {
		logger.info("----Update Hangar Form Submitted in Hangar Controller----");

		ModelAndView mv=new ModelAndView();
		ValidationUtils.invokeValidator(validator, hangarModel , errors);
		ModelMap mapDummy=new ModelMap();
		if(errors.hasErrors())
		{
			logger.info("----Updation of Hangar Failed in Hangar Controller----");
			mv.addObject("status", "Hangar registration failed, TRY Again");
			mv.setViewName("viewOneHangar");
			mapDummy.addAttribute("status", "Your details are submitted successfully");
		}
		else
		{
			boolean hangarUpdate=hangarService.updateHangar(hangarModel);
			if(hangarUpdate)
			{
				logger.info("----Updation of Hangar Successful in Hangar Controller----");
				mv.addObject("status", "Your details are submitted successfully");
				mapDummy.addAttribute("status", "Registration failed, TRY Again");
			}
			else
			{
				logger.info("----Updation of Hangar Failed in Hangar Controller----");
				mv.addObject("status", "Registration failed, TRY Again");			
				mapDummy.addAttribute("status", "Registration failed, TRY Again");
			}
		}
			mv.setViewName("viewOneHangar");		
		return mv;
	}
	
	/*
	 * To load adminRegister jsp page, Admin can fill the required information
	 */

	@RequestMapping(value="viewHangerAllocation.htm",method=RequestMethod.GET)
	public ModelAndView setAllocationView(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);	
		if(session.getAttribute("managerId")==null){
			throw new SessionExpired("Session Expired");
		}
		else
		{
		logger.info("----View All Hangar Status in Hangar Controller----");
		List<HangarStatus> hangarStatusList = hangarService.getAllHangarStatus();
		ModelAndView mv = new ModelAndView();
		mv.addObject("hangarStatusList", hangarStatusList);
		mv.setViewName("viewHangerAllocation");
		return mv;
		}
	}
	
	/*
	 * Dispaly hangerAllocationForm page allow user
	 * 
	 * to enter allocate hanger to different planes
	 */
	
	@RequestMapping(value="hangarAllocationForm.htm",method=RequestMethod.GET)
	public ModelAndView viewAllocationForm(ModelMap map,@RequestParam("hangarId")int hangarId,@RequestParam("managerId")String managerId){
		
		ModelAndView mv = new ModelAndView();
		
		if(hangarService.getStatusCondition(hangarId).equals("O")){
			
			throw new AllocationException("You cant allocate an allocated hangar");
		}
		else{
		logger.info("----Allocate Hangars in Hangar Controller----");
		List<Number> planeIdList =planeService.getAllPlaneId();
		
				
		
		mv.addObject("planeIdList",planeIdList);
	    map.addAttribute("hangarId",hangarId);
		map.addAttribute("managerId",managerId);
		mv.setViewName("hangarAllocationForm");		
		return mv;
		}
	}
	
	/*
	 * Allocate planes to different hanger details
	 */
	
	@RequestMapping(value="addPlaneIntoHanger.htm",method=RequestMethod.POST)
	public ModelAndView allocatePlane(@ModelAttribute("hangarStatusModel")HangarStatusModel hangarStatusModel){
		
		logger.info("----Allocate Plane to Hangars in Hangar Controller----");
		ModelAndView mv = new ModelAndView();
		
	
		
		hangarService.allocatePlane(hangarStatusModel);
		List<Number> planeIdList =planeService.getAllPlaneId();
		mv.addObject("planeIdList",planeIdList);
		mv.setViewName("hangarAllocationForm");
		return mv;
	}
	
	/*
	 * Get all the list of hangers and check weather the hangar is occupied
	 * or Available.
	 */
	
	@RequestMapping(value="viewHangarStatus.htm",method=RequestMethod.GET)
	public ModelAndView viewHangarStatus(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session.getAttribute("managerId")==null){
			throw new SessionExpired("Session Expired");
		}
		else
		{
		logger.info("----View All Hangar Status in Hangar Controller----");
		List<HangarStatus> hangarStatusList = hangarService.getAllHangarStatus();
		ModelAndView mv = new ModelAndView();
		mv.addObject("hangarStatusList", hangarStatusList);
		mv.setViewName("viewHangarStatus");
		return mv;
		}
	}	
	
	/*
	 * Update hanger details 
	 */
	
	@RequestMapping(value = "viewOneHangarStatus.htm", method = RequestMethod.GET)
	public ModelAndView viewHangarStatus(ModelMap map, @ModelAttribute("hangarStatusModel") HangarStatusModel hangarStatusModel,
			@RequestParam("hangarId") int hangar1) {
		logger.info("----View One Hangar Status Details in Hangar Controller----");
		ModelAndView mv = new ModelAndView();
		
if(hangarService.getStatusCondition(hangar1).equals("A")){
			
			throw new AllocationException("You cant allocate an allocated hangar");
		}
		HangarStatusModel view1HangarStatusModel = hangarService.getHangarStatus(hangar1);
		map.addAttribute("view1HangarStatusModel", view1HangarStatusModel);
		mv.setViewName("viewOneHangarStatus");
		return mv;
	}
	
	/*
	 * Take all the information from user and update the hangar details
	 */
	
	@RequestMapping(value = "editHangarStatus.htm", method = RequestMethod.POST)
	public ModelAndView updateHangarStatus(@ModelAttribute("view1HangarStatusModel") HangarStatusModel hangarStatusModel, Errors errors) {
		
		logger.info("----Update Hangar Status Form Submitted in Hangar Controller----");
		ModelAndView mv = new ModelAndView();
	
			ModelMap mapDummy=new ModelMap();
			boolean hangarStatusUpdate = hangarService.updateHangarStatus(hangarStatusModel);
			if (hangarStatusUpdate) {
				logger.info("----Updation of Hangar Status Successful in Hangar Controller----");
				mv.addObject("status", "Your details are submitted successfully");
				mapDummy.addAttribute("status", "Your details are submitted successfully");
			} else {
				logger.info("----Updation of Hangar Status Failed in Hangar Controller----");
				mv.addObject("status", "Hangar Status Updation failed, TRY Again");
				mapDummy.addAttribute("status", "Please update the highlighted mandatory field(s)");
			}
		mv.setViewName("viewOneHangarStatus");
		return mv;
	}

	/*
	 * Returning all the details of Hangar Status
	 */
	
	@ModelAttribute("hangarStatusModel")
	public HangarStatusModel createCommandObject1() {
		logger.info("----Model Attribute of Hangar Status class in Hangar Controller----");
		HangarStatusModel hangarStatusModel = new HangarStatusModel();
		return hangarStatusModel;
	}

	/*
	 * Returning all the details of Hangar 
	 */
	
	@ModelAttribute("hangarModel")
	public HangarModel createCommandObject() {
		logger.info("----Model Attribute of Hangar class in Hangar Controller----");
		HangarModel hangarModel = new HangarModel();
		return hangarModel;
	}

	/*
	 * Getting the Hangar status from the database
	 */
	
	@ModelAttribute("statusList")
	public List<String> createStatusList(){
		logger.info("----Retriving Status from Database in Hangar Controller----");
		return hangarService.getStatus();
	}
	
	/*
	 * when session is expired restrict the allocation request
	 */
	
	@ExceptionHandler(SessionExpired.class)
	ModelAndView exceptionHandle(){
		logger.info("----Session Expired Exception Handler in Hangar Controller----");
		ModelAndView mv = new ModelAndView();
		String msg ="Sorry we cannot process your request";
		mv.addObject("msg",msg);
		mv.setViewName("error");
		return mv;
		
	}
	
	/*
	 * When the hangar is already occupied cannot be allocated again
	 */
	
	@ExceptionHandler(AllocationException.class)
	ModelAndView exceptionAllocationHandle(){
		logger.info("----Allocation Exception Handler in Hangar Controller----");
		ModelAndView mv = new ModelAndView();
		String msg ="Sorry you can not allocate an allocated hangar";
		mv.addObject("msg",msg);
		mv.setViewName("allocationError");
		return mv;		
	}
	

	/*
	 * No Hangar is found 
	 */
	
	@ExceptionHandler(HangarNotFound.class)
	ModelAndView hangarNotFound(HangarNotFound e){
		logger.info("----Hangar Not Found Exception Handler in Hangar Controller----");
		ModelAndView mv = new ModelAndView();
		mv.addObject("e",e);
		mv.setViewName("hangarNotFoundError");
		return mv;		
	}


}