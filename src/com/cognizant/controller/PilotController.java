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

import com.cognizant.entity.Pilot;
import com.cognizant.exception.PilotNotFound;
import com.cognizant.exception.SessionExpired;
import com.cognizant.model.PilotModel;
import com.cognizant.service.PilotService;

/**
 * 
 * @author 768817
 *
 *This controller will manage pilot information flow. 
 */

@Controller
@SessionAttributes("view1PilotModel")
public class PilotController {

	@Autowired
	private PilotService pilotService;

	@Autowired
	@Qualifier("pilotValidator")
	private Validator validator;
	
	private static final Logger logger = LoggerFactory.getLogger(PilotController.class);
			
	/*
	  *Admin is logged in then pioletMain page will be loaded.
	  * 
	  */
	
	@RequestMapping(value="pilotMain.htm",method=RequestMethod.GET)
	public String loadPilotMain(HttpServletRequest request){
		HttpSession session=request.getSession(false);
		
		if(session.getAttribute("adminId")==null){
			throw new SessionExpired("Session Expired");
		}
		else
		{
			logger.info("----Loading Pilot Main Page in Pilot Controller----");
			return "pilotMain";
		}		
	}
	
	@RequestMapping(value="pilotForm.htm",method=RequestMethod.GET)
	public String loadPilotForm(){
		logger.info("----Loading Add Pilot Form in Pilot Controller----");
		return "pilotForm";
	}

	/*
	  * Check all the details entered are valid or meet the requirements.
	  * And persist the informations to the database.
	  */
	
	@RequestMapping(value="addPilot.htm",method=RequestMethod.POST)
	public ModelAndView persistPilot(@ModelAttribute("pilotModel")PilotModel pilotModel,Errors errors){
				
		ModelAndView mv=new ModelAndView();
		logger.info("----Add Pilot Form Submitted in Pilot Controller----");

		ValidationUtils.invokeValidator(validator, pilotModel , errors);
		ModelMap mapDummy=new ModelMap();
		if(errors.hasErrors())
		{
			logger.info("----Addition of Pilot Failed in Pilot Controller----");
			mv.setViewName("pilotForm");
			mapDummy.addAttribute("status", "Please update the highlighted mandatory field(s)");
		}
		else
		{
			boolean pilotPersist=pilotService.persistPilot(pilotModel);
			if(pilotPersist)
			{
				logger.info("----Addition of Pilot Successful in Pilot Controller----");
				mv.addObject("status", "Your details are submitted successfully");
				mapDummy.addAttribute("status", "Your details are submitted successfully");
			}
			else
			{
				logger.info("----Addition of Pilot Failed in Pilot Controller----");
				mv.addObject("status", "Please update the highlighted mandatory field(s)");			
				mapDummy.addAttribute("status", "Please update the highlighted mandatory field(s)");
			}
		}
		mv.setViewName("pilotForm");		
		return mv;
	}
	
	/*
	  * Display Pilots details how many Pilots are there.
	  */
	
	@RequestMapping(value = "viewPilots.htm", method = RequestMethod.GET)
	public ModelAndView viewPilots() {
		logger.info("----View All Pilots in Pilot Controller----");		
		List<Pilot> pilotList = pilotService.getAllPilots();
		ModelAndView mv = new ModelAndView();
		mv.addObject("pilotList", pilotList);
		mv.setViewName("viewPilots");
		return mv;
	}

	/*
	  * view single pilot details.
	  */
	
	@RequestMapping(value="viewOnePilot.htm",method=RequestMethod.GET)
	public ModelAndView viewPilot(ModelMap map,@ModelAttribute("pilotmodel") PilotModel pilotModel,@RequestParam("pilotId")int pilot1)
	{	
		logger.info("----View One Pilot Details in Pilot Controller----");
		ModelAndView mv=new ModelAndView();	
		PilotModel view1PilotModel = pilotService.getPilot(pilot1);		
		map.addAttribute("view1PilotModel",view1PilotModel);
		mv.setViewName("viewOnePilot");
		return mv;
	}

	/*
	  * Allow authorized user to make changes in the pilots details.
	  */
	
	@RequestMapping(value="editPilot.htm",method=RequestMethod.POST)
	public ModelAndView updatePilot(@ModelAttribute("view1PilotModel")PilotModel pilotModel,Errors errors){
		logger.info("----Update Pilot Form Submitted in Pilot Controller----");

		ModelAndView mv=new ModelAndView();
		ValidationUtils.invokeValidator(validator, pilotModel , errors);
		ModelMap mapDummy=new ModelMap();
		if(errors.hasErrors())
		{
			logger.info("----Updation of Pilot Failed in Pilot Controller----");
			mv.addObject("status", "Pilot registration failed, TRY Again");
			mv.setViewName("viewOnePilot");
			mapDummy.addAttribute("status", "Your details are submitted successfully");
		}
		else
		{
			boolean pilotUpdate=pilotService.updatePilot(pilotModel);
			if(pilotUpdate)
			{
				logger.info("----Updation of Pilot Successful in Pilot Controller----");
				mv.addObject("status", "Your details are submitted successfully");
				mapDummy.addAttribute("status", "Registration failed, TRY Again");
			}
			else
			{
				logger.info("----Updation of Pilot Failed in Pilot Controller----");
				mv.addObject("status", "Registration failed, TRY Again");			
				mapDummy.addAttribute("status", "Registration failed, TRY Again");
			}
		}
			mv.setViewName("viewOnePilot");		
		return mv;
	}

	@ModelAttribute("pilotModel")                            
	public PilotModel createCommandObject(){                 
		logger.info("----Model Attribute of Pilot class in Pilot Controller----");
		PilotModel pilotModel=new PilotModel();                      
		return pilotModel;
	}

	/*
	  * if session expired and user try to check the page data it will be handled
	  * by this method.
	  */
	
	@ExceptionHandler(SessionExpired.class)
	ModelAndView exceptionHandle(){
		logger.info("----Session Expired Exception Handler in Pilot Controller----");
		ModelAndView mv = new ModelAndView();
		String msg ="Sorry we cannot process your request";
		mv.addObject("msg",msg);
		mv.setViewName("error");
		return mv;		
	}
	
	/*
	 * Pilot not found
	 */
	@ExceptionHandler(PilotNotFound.class)
	ModelAndView pilotNotFound(PilotNotFound e){
		logger.info("----Pilot Not Found Exception Handler in Pilot Controller----");
		ModelAndView mv = new ModelAndView();
		mv.addObject("e",e);
		mv.setViewName("pilotNotFoundError");
		return mv;		
	}
}