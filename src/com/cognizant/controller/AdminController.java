package com.cognizant.controller;

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

import com.cognizant.entity.Manager;

import com.cognizant.exception.AdminNotFoundException;
import com.cognizant.exception.SessionExpired;
import com.cognizant.helper.SessionHelper;
import com.cognizant.model.AdminModel;
import com.cognizant.service.AdminService;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
 * 
 * @author 768817
 * 
 * Controller Class: Controlling the flow of Admin entity
 *
 */

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	@Qualifier("adminLoginValidator")
	private Validator loginValidator;
	
	@Autowired
	@Qualifier("adminRegistrationValidator")
	private Validator registerValidator;
		
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	/*
	 * To load adminRegister jsp page, Admin can fill the required information
	 */
	
	@RequestMapping(value="adminRegister.htm")
	public ModelAndView loadRegisterAdmin(ModelMap map,HttpServletRequest request){
		logger.info("----Loading Admin Registration Page in Admin Controller----");		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminRegister");
		return mv;
	}
	
	/*
	 * Take all the registration information and pass 
	 * that information to model Attribute and save it in database
	 */
	
	@RequestMapping(value ="adminRegisterSuccess.htm", method = RequestMethod.POST)
	public ModelAndView registerAdmin(@ModelAttribute("adminDummy")AdminModel adminModel,Errors errors){
		logger.info("----Admin Registration Page Submitted in Admin Controller----");
						
		ModelAndView mv = new ModelAndView();
		
		logger.info("----Admin Registration Validator is invoked in Admin Controller----");
		ValidationUtils.invokeValidator(registerValidator, adminModel , errors);
		ModelMap mapDummy=new ModelMap();
		if(errors.hasErrors())
		{
			logger.info("----Admin Registration Failed in Admin Controller----");
			mv.setViewName("adminRegister");
			mapDummy.addAttribute("status","Admin Registration Failed");
		}
		else{
		boolean persistAdmin=adminService.registerAdmin(adminModel);
		if(persistAdmin)
		{
			logger.info("----Admin Registration Successfully in Admin Controller----");
			String Id=adminService.getId();
			mv.addObject("status","Admin Registered");
			mv.addObject("adminMSG", adminModel.getAdminFirstName()+" "+adminModel.getAdminLastName()+" can Login using =>");
			mv.addObject("note", "Admin Id : ");
			mv.addObject("adminId", Id);
		}
		else{
			logger.info("----Admin Registration Failed in Admin Controller----");
			mv.addObject("status","Admin Registration Failed");
		}
		}
		mv.setViewName("adminRegister");
		return mv;
	}
	
	/*
	 * To show adminLogin page
	 */	
	
	@RequestMapping(value="adminLogin.htm")
	public String loadAdminLogin(){
		logger.info("----Loading Admin Login Page in Admin Controller--------");
		return "adminLogin";
	}

	/*
	 * Ask from Admin to enter his/her id and password and check those entries with databse and allow admin to sucessfully login 
	 * with welcome jsp page if all
	 * the entries are matched.
	 * 
	 * 
	 *  if the credentials are not valid or any field is not filled correctly 
	 *  show the error message and show the adminRegister page again.
	 */
	
	@RequestMapping(value="adminLoginSuccess.htm",method=RequestMethod.POST)
	public ModelAndView adminLogin(@ModelAttribute("adminModel") AdminModel adminModel,Errors errors,HttpServletRequest request)
	{
		HttpSession session=request.getSession(true);
		logger.info("----Admin Login Page Submitted in Admin Controller--------");
		ModelAndView mv=new ModelAndView();
		logger.info("----Admin Login Validator is invoked in Admin Controller--------");
		ValidationUtils.invokeValidator(loginValidator, adminModel , errors);
		if(errors.hasErrors())
		{
			logger.info("----Admin Login Failed in Admin Controller--------");
			mv.setViewName("adminLogin");
		}
		else
		{
			logger.info("----Admin Login Successful in Admin Controller----");
			mv.addObject("status","Admin Login Successful");
			String adminId=adminModel.getAdminId();
			
			AdminModel adminModelInfo=adminService.getAdminInfo(adminId);
			
			session.setAttribute("adminId",adminId);
			session.setAttribute("adminName",adminModelInfo.getAdminFirstName()+" "+adminModelInfo.getAdminLastName());
			session.setAttribute("adminAge", adminModelInfo.getAdminAge());
			session.setAttribute("adminGender", adminModelInfo.getAdminGender());
			session.setAttribute("adminDob", adminModelInfo.getAdminDob());
			session.setAttribute("adminContactNo", adminModelInfo.getAdminContactNo());
			session.setAttribute("adminEmail", adminModelInfo.getAdminEmailId());
			mv.setViewName("welcomeAdmin");
		}
		return mv;
	}

	/*
	 * To display all the Manager Pending requests those  
	 * need admin approval to login.
	 */
	
	@RequestMapping(value="managerPendingRequests.htm",method=RequestMethod.GET)
	public ModelAndView getAllManagerrequests(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();		
		HttpSession session=request.getSession(false);		
		if(session.getAttribute("adminId")==null){
			logger.info("----Session Expired Exception Occurred in Admin Controller--------");
				throw new SessionExpired("Session Expired");
		}
		
		else
		{
		logger.info("----Loading Manager Pending Request in Admin Controller--------");
	
		
		
		List<Manager> managerPendingRequests=adminService.getAllPendingRequests();
		mv.addObject("managerList",managerPendingRequests);
		
		
		
		mv.setViewName("managerRequest");
		return mv;
		}
	}

	/*
	 * Admin will Approve or Reject all pending requests and 
	 * 
	 * Only
	 * 
	 * Approved managers will be able to login successfully
	 */
	
	@RequestMapping(value="changeRequestStatus.htm")
	public ModelAndView changeRequestStatus(@RequestParam("managerId")String managerId,@RequestParam("action")String action){
		logger.info("----Loading Update Change Manager Status");
		ModelAndView mv=new ModelAndView();
		
		if(action.equals("approve"))
		{
			
			logger.info("----Manager Status Approved in Admin Controller----");
			boolean approveStatus=adminService.approveManagerRequest(managerId);			
			if(approveStatus)
			mv.addObject("status","Approved");
		} else
		{
			
			boolean rejectStatus=adminService.rejectManagerRequest(managerId);
		
			if(rejectStatus)
			{	
				logger.info("----Manager Status Rejected in Admin Controller----");
				mv.addObject("status","Rejected");
			}
		}
		List <Manager> managerPendingRequests=adminService.getAllPendingRequests();
		mv.addObject("managerList",managerPendingRequests);
		
		
		
		mv.setViewName("managerRequest");
		return mv;
	}
	
	/*
	 * Show Admin Login Page
	 */
	
	@RequestMapping(value="welcomeAdmin.htm")
	public String loadAdminWelcome(){
		logger.info("----Loading Admin Welcome Page in Admin Controller----");
		return "welcomeAdmin";
	}

	/*
	 * when admin click on logout this page will be displayed
	 */
	
	@RequestMapping(value="adminLogout.htm",method=RequestMethod.GET)
	public String logout (HttpServletRequest request){
		HttpSession session=request.getSession(false);
	
		session.removeAttribute("adminId");
		session.invalidate();
		logger.info("----Admin Logout Successful in Admin Controller----");
		return "main";
	}
	
	/*
	 * Model Attribute  annotation to make a model Object of adminModel to take all the information
	 * from the Admin Login Or Admin Registration page and save them in this object
	 * for further operations
	 */
	
	@ModelAttribute("adminModel")
	public AdminModel createAdminObject(){
		logger.info("----Model Attribute of AdminModel class in Admin Controller----");
		AdminModel adminModel = new AdminModel();
		return adminModel;
	}
	
	/*
	 * provide the list of gender from the database
	 */
	
	@ModelAttribute("genderList")
	public List<String> createGenderList(){
		logger.info("----Retriving Gender from Database in Admin Controller----");
		return adminService.getGender();
	}

	/*
	 * when session is expired restrict the admin to login
	 */
	
	@ExceptionHandler(SessionExpired.class)
	ModelAndView exceptionHandle(){
		logger.info("----Session Expired Exception Handler in Admin Controller----");
		ModelAndView mv = new ModelAndView();
		String msg ="Sorry we cannot process your request";
		mv.addObject("msg",msg);
		mv.setViewName("error");
		return mv;
		
	}

	/*
	 * If provided information does not match with the database entries 
	 * this page will be displayed 
	 */
	
	@ExceptionHandler(AdminNotFoundException.class)
	ModelAndView adminNotFoundException(){
		logger.info("----Admin Not Found Exception Handler in Admin Controller----");
		ModelAndView mv = new ModelAndView();
		String msg ="Admin Not Found Exception";
		mv.addObject("msg",msg);
		mv.setViewName("adminNotFoundError");
		return mv;		
	}

}