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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.exception.ManagerNotFoundException;
import com.cognizant.helper.SessionHelper;
import com.cognizant.model.ManagerModel;
import com.cognizant.service.ManagerService;

/**
 * 
 * @author 768817
 *
 *ManagerController : will manage all the functionality login 
 *
 *as well as database entries and session management 
 */

@Controller
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	@Autowired
	@Qualifier("managerLoginValidator")
	private Validator loginValidator;
	
	@Autowired
	@Qualifier("managerRegistrationValidator")
	private Validator registerValidator;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	@RequestMapping("managerRegister")
	public String viewManagerReg(){
		logger.info("----Loading Manager Registration Page in Manager Controller----");
		return "managerRegister";
	}
	
	 /*
	  * Checking the session and restrict the integrity or duplicasy of the data if current user
	  * try to make new entry with the same session id.
	  */
	
	@RequestMapping("managerRegisterSuccess.htm")
	public ModelAndView viewRegistrationPage(@ModelAttribute("managerModel") ManagerModel managerModel,Errors errors){
		logger.info("----Manager Registration Page Submitted in Manager Controller----");
		ModelAndView mv = new ModelAndView();	

		logger.info("----Manager Registration Validator is invoked in Manager Controller----");
		ValidationUtils.invokeValidator(registerValidator, managerModel , errors);
		if(errors.hasErrors())
		{
			logger.info("----Manager Registration Failed in Manager Controller----");
			mv.setViewName("managerRegister");
		}
		else
		{
		boolean persistManager=managerService.managerRegister(managerModel);
		if(persistManager)
		{
			logger.info("----Manager Registration Successfully in Manager Controller----");
			String Id=managerService.getId();
			mv.addObject("status","Manager Registered");
			mv.addObject("managerMSG", managerModel.getManagerFirstName()+" "+managerModel.getManagerLastName()+" can Login using =>");
			mv.addObject("note", "Manager Id : ");
			mv.addObject("managerId", Id);
		}
		else{
			logger.info("----Manager Registration Failed in Manager Controller----");
			mv.addObject("status","Manager Registration Failed");
		}
		}
		mv.setViewName("managerRegister");
		return mv;
	}
	
	 /*
	  * Checking the session and restrict the integrity or duplicasy of the data if current user
	  * try to make new entry with the same session id.
	  */
	
	@RequestMapping("managerLogin.htm")
	public String viewManagerlogin(){
		logger.info("----Loading Manager Login Page in Manager Controller--------");
		return "managerLogin";
	}

	/*
	  * Check the entered entries are correct with the database
	  * 
	  * and check manager has the approval to login from the admin
	  */
	
	@RequestMapping(value="managerLoginSuccess.htm",method=RequestMethod.POST)
	public ModelAndView managerLogin(@ModelAttribute("managerModel") ManagerModel managerModel,Errors errors,HttpServletRequest request)
	{
		HttpSession session=request.getSession(true);
		logger.info("----Manager Login Page Submitted in Manager Controller--------");
		ModelAndView mv=new ModelAndView();
		logger.info("----Manager Login Validator is invoked in Manager Controller--------");
		ValidationUtils.invokeValidator(loginValidator, managerModel , errors);
		if(errors.hasErrors())
		{
			logger.info("----Manager Login Failed in Manager Controller--------");
			mv.setViewName("managerLogin");
		}
		else 
		{
			logger.info("----Manager Login Successful in Manager Controller--------");
			mv.addObject("status","Manager Login Successful");
			String managerId=managerModel.getManagerId();
			
			ManagerModel managerModelInfo=managerService.getManagerInfo(managerId);
			
			session.setAttribute("managerId",managerId);
			session.setAttribute("managerName",managerModelInfo.getManagerFirstName()+" "+managerModelInfo.getManagerLastName());
			session.setAttribute("managerAge", managerModelInfo.getManagerAge());
			session.setAttribute("managerGender", managerModelInfo.getManagerGender());
			session.setAttribute("managerDob", managerModelInfo.getManagerDob());
			session.setAttribute("managerContactNo", managerModelInfo.getManagerContactNo());
			session.setAttribute("managerEmail", managerModelInfo.getManagerEmailId());
			mv.setViewName("welcomeManager");
		}
		return mv;		
	}

	/*
	  * Destroy session id and prevent user to access resources.
	  */
	
	
	@RequestMapping(value="managerLogout.htm",method=RequestMethod.GET)
	public ModelAndView logout (HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		
        HttpSession session=request.getSession(false);
		session.removeAttribute("managerId");
		session.invalidate();

		logger.info("----Manager Logout Successful in Manager Controller----");
		mv.setViewName("main");
		return mv;
	}
	

	/*
	  * display manger welcome page after succesfully login.
	  */
	
	@RequestMapping(value="welcomeManager.htm")
	public String loadManagerWelcome(){
		logger.info("----Loading Manager Welcome Page in Manager Controller----");
		return "welcomeManager";
	}
	
	/*
	  * store information during during login and Registration in the form of an object.
	  */
	
	@ModelAttribute("managerModel")
	public ManagerModel managerObject(){
		logger.info("----Model Attribute of ManagerModel class in Manager Controller----");
		ManagerModel  managerModel = new ManagerModel();
		return managerModel;
	}
	
	@ModelAttribute("genderList")
	public List<String> createGenderList(){
		logger.info("----Retriving Gender from Database in Manager Controller----");
		return managerService.getGender();
	}

	/*
	  * If the details are not correct or any exception occurs
	  * handle it and manger it with the display of new error page.
	  */
	
	@ExceptionHandler(ManagerNotFoundException.class)
	ModelAndView managerNotFoundException(){
		logger.info("----Manager Not Found Exception Handler in Manager Controller----");
		ModelAndView mv = new ModelAndView();
		String msg ="Manager Not Found Exception";
		mv.addObject("msg",msg);
		mv.setViewName("managerNotFoundError");
		return mv;		
	}
	
}
