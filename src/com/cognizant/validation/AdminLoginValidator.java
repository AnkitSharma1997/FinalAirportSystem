package com.cognizant.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cognizant.model.AdminModel;
import com.cognizant.service.AdminService;

@Component
public class AdminLoginValidator implements Validator{

	@Autowired
	private AdminService adminService;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminLoginValidator.class);

	@Override
	public boolean supports(Class<?> arg0) {
		logger.info("----Admin Model class in supports of Admin Login Validator----");
		return arg0.equals(AdminModel.class);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		logger.info("----Admin Model class in validate of Admin Login Validator----");
		AdminModel adminModel=(AdminModel)arg0;
		
		ValidationUtils.rejectIfEmpty(arg1, "adminId", "adminId.required");
		ValidationUtils.rejectIfEmpty(arg1, "adminPassword", "adminPassword.required");

		if(adminModel.getAdminId()!="" && adminModel.getAdminPassword()!="")
		{	
		int adminAuth=adminService.checkAdminLogin(adminModel);
		if(adminAuth==1)
		{
			arg1.rejectValue("adminId", "com.cognizant.entity.Admin.adminId.invalid");
		}
		else if(adminAuth==2)
		{
			arg1.rejectValue("adminPassword", "com.cognizant.entity.Admin.adminPassword.invalid");
		}
		else if(adminAuth==3)
		{
			arg1.rejectValue("adminId", "com.cognizant.entity.Admin.adminId.invalid");
			arg1.rejectValue("adminPassword", "com.cognizant.entity.Admin.adminPassword.invalid");
		}
		}
	}

}
