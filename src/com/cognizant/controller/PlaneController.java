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

import com.cognizant.entity.Plane;
import com.cognizant.exception.PlaneNotFound;
import com.cognizant.exception.PlaneNotFound;
import com.cognizant.exception.SessionExpired;
import com.cognizant.model.PlaneModel;
import com.cognizant.service.PlaneService;

/**
 * 
 * @author 768817
 *Plane Controller handle the flow of plane operations
 */

@Controller
@SessionAttributes("view1PlaneModel")
public class PlaneController {

	@Autowired
	private PlaneService planeService;

	@Autowired
	@Qualifier("planeValidator")
	private Validator validator;
	
	private static final Logger logger = LoggerFactory.getLogger(PlaneController.class);
			
	/*
	  *if session is not expired display the plane main page. 
	  */
	
	@RequestMapping(value="planeMain.htm",method=RequestMethod.GET)
	public String loadPlaneMain(HttpServletRequest request){
		
		HttpSession session=request.getSession(false);
		if(session.getAttribute("adminId")==null)
		{
				throw new SessionExpired("Session Expired");
		}
		else
		{
			logger.info("----Loading Hangar Main Page in Plane Controller----");
			return "planeMain";
		}
	}
	
	@RequestMapping(value="planeForm.htm",method=RequestMethod.GET)
	public String loadPlaneForm(){
		logger.info("----Loading Add Plane Form in Plane Controller----");
		return "planeForm";
	}

	/*
	  * If all entries are valid with the requirements
	  * 
	  * then persist the data in database.
	  */
	
	@RequestMapping(value="addPlane.htm",method=RequestMethod.POST)
	public ModelAndView persistPlane(@ModelAttribute("planeModel")PlaneModel planeModel,Errors errors){
		
		ModelAndView mv=new ModelAndView();
		logger.info("----Add Plane Form Submitted in Plane Controller----");

		ValidationUtils.invokeValidator(validator, planeModel , errors);
		ModelMap mapDummy=new ModelMap();
		if(errors.hasErrors())
		{
			logger.info("----Addition of Plane Failed in Plane Controller----");
			mv.setViewName("planeForm");
			mapDummy.addAttribute("status", "Please update the highlighted mandatory field(s)");
		}
		else
		{
			boolean planePersist=planeService.persistPlane(planeModel);
			if(planePersist)
			{
				logger.info("----Addition of Plane Successful in Plane Controller----");
				mv.addObject("status", "Your details are submitted successfully");
				mapDummy.addAttribute("status", "Your details are submitted successfully");
			}
			else
			{
				logger.info("----Addition of Plane Failed in Plane Controller----");
				mv.addObject("status", "Please update the highlighted mandatory field(s)");			
				mapDummy.addAttribute("status", "Please update the highlighted mandatory field(s)");
			}
		}
		mv.setViewName("planeForm");		
		return mv;
	}
	
	/*
	  * Get all the plane details.
	  */
	
	@RequestMapping(value = "viewPlanes.htm", method = RequestMethod.GET)
	public ModelAndView viewPlanes() {
		logger.info("----View All Planes in Plane Controller----");		
		List<Plane> planeList = planeService.getAllPlanes();
		ModelAndView mv = new ModelAndView();
		mv.addObject("planeList", planeList);
		mv.setViewName("viewPlanes");
		return mv;
	}


	/*
	  * Display single plane informations.
	  */
	
	@RequestMapping(value="viewOnePlane.htm",method=RequestMethod.GET)
	public ModelAndView viewPlane(ModelMap map,@ModelAttribute("planemodel") PlaneModel planeModel,@RequestParam("planeId")int plane1)
	{	
		logger.info("----View One Plane Details in Plane Controller----");
		ModelAndView mv=new ModelAndView();	
		PlaneModel view1PlaneModel = planeService.getPlane(plane1);		
		map.addAttribute("view1PlaneModel",view1PlaneModel);
		mv.setViewName("viewOnePlane");
		return mv;
	}

	/*
	  * make the Updation in the plane details allow user to 
	  * select plane id on which he/she want to make the changes.
	  */
	
	@RequestMapping(value="editPlane.htm",method=RequestMethod.POST)
	public ModelAndView updatePlane(@ModelAttribute("view1PlaneModel")PlaneModel planeModel,Errors errors){
		logger.info("----Update Plane Form Submitted in Plane Controller----");

		ModelAndView mv=new ModelAndView();
		ValidationUtils.invokeValidator(validator, planeModel , errors);
		ModelMap mapDummy=new ModelMap();
		if(errors.hasErrors())
		{
			logger.info("----Updation of Plane Failed in Plane Controller----");
			mv.addObject("status", "Plane registration failed, TRY Again");
			mv.setViewName("viewOnePlane");
			mapDummy.addAttribute("status", "Your details are submitted successfully");
		}
		else
		{
			boolean planeUpdate=planeService.updatePlane(planeModel);
			if(planeUpdate)
			{
				logger.info("----Updation of Plane Successful in Plane Controller----");
				mv.addObject("status", "Your details are submitted successfully");
				mapDummy.addAttribute("status", "Registration failed, TRY Again");
			}
			else
			{
				logger.info("----Updation of Plane Failed in Plane Controller----");
				mv.addObject("status", "Registration failed, TRY Again");			
				mapDummy.addAttribute("status", "Registration failed, TRY Again");
			}
		}
			mv.setViewName("viewOnePlane");		
		return mv;
	}

	/*
	  * plane details will be stored in model Object.
	  */
	
	
	@ModelAttribute("planeModel")                            
	public PlaneModel createCommandObject(){                 
		logger.info("----Model Attribute of Plane class in Plane Controller----");
		PlaneModel planeModel=new PlaneModel();                      
		return planeModel;
	}
	
	/*
	  * if anything goes wrong exceptions will be handled by these method.
	  */
	
	@ExceptionHandler(SessionExpired.class)
	ModelAndView exceptionHandle(){
		logger.info("----Session Expired Exception Handler in Plane Controller----");
		ModelAndView mv = new ModelAndView();
		String msg ="Sorry we cannot process your request";
		mv.addObject("msg",msg);
		mv.setViewName("error");
		return mv;
	}
	/*
	 * Plane not found
	 */
	@ExceptionHandler(PlaneNotFound.class)
	ModelAndView planeNotFound(PlaneNotFound e){
		logger.info("----Plane Not Found Exception Handler in Plane Controller----");
		ModelAndView mv = new ModelAndView();
		mv.addObject("e",e);
		mv.setViewName("planeNotFoundError");
		return mv;		
	}
}