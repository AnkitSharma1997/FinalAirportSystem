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
public class AdminRegistrationValidator implements Validator{

	@Autowired
	private AdminService adminService;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminRegistrationValidator.class);

	@Override
	public boolean supports(Class<?> arg0) {
		logger.info("----Admin Model class in supports of Admin Registration Validator----");
		return arg0.equals(AdminModel.class);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {		
		logger.info("----Admin Model class in validate of Admin Registration Validator----");
		AdminModel adminModel=(AdminModel)arg0;
		
		ValidationUtils.rejectIfEmpty(arg1, "adminFirstName", "adminFirstName.required");
		ValidationUtils.rejectIfEmpty(arg1, "adminLastName", "adminLastName.required");
		ValidationUtils.rejectIfEmpty(arg1, "adminAge", "adminAge.required");
		ValidationUtils.rejectIfEmpty(arg1, "adminDob", "adminDob.required");
		ValidationUtils.rejectIfEmpty(arg1, "adminContactNo", "adminContactNo.required");
		ValidationUtils.rejectIfEmpty(arg1, "adminEmailId", "adminEmailId.required");
		ValidationUtils.rejectIfEmpty(arg1, "adminPassword", "adminPassword.required");
		
		if(adminModel.getAdminEmailId()!="" && adminModel.getAdminContactNo()!=0)
		{
		int adminExists=adminService.checkEmailAndContactNo(adminModel);
		
		if(adminExists==1)
		{
			arg1.rejectValue("adminEmailId", "com.cognizant.entity.Admin.adminEmailId.duplicate");
		}
		else if(adminExists==2)
		{
			arg1.rejectValue("adminContactNo", "com.cognizant.entity.Admin.adminContactNo.duplicate");
		}
		else if(adminExists==3)
		{
			arg1.rejectValue("adminEmailId", "com.cognizant.entity.Admin.adminEmailId.duplicate");
			arg1.rejectValue("adminContactNo", "com.cognizant.entity.Admin.adminContactNo.duplicate");
		}
		}
	}

}
