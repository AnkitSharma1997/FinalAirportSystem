package com.cognizant.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cognizant.model.ManagerModel;
import com.cognizant.service.ManagerService;

@Component
public class ManagerLoginValidator implements Validator{

	@Autowired
	private ManagerService managerService;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagerLoginValidator.class);

	@Override
	public boolean supports(Class<?> arg0) {
		logger.info("----Manager Model class in supports of Manager Login Validator----");
		return arg0.equals(ManagerModel.class);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		logger.info("----Manager Model class in validate of Manager Login Validator----");
		ManagerModel managerModel=(ManagerModel)arg0;
		
		ValidationUtils.rejectIfEmpty(arg1, "managerId", "managerId.required");
		ValidationUtils.rejectIfEmpty(arg1, "managerPassword", "managerPassword.required");

		if(managerModel.getManagerId()!="" && managerModel.getManagerPassword()!="")
		{	
		int managerAuth=managerService.checkCredentilas(managerModel);
		if(managerAuth==2)
		{
			arg1.rejectValue("managerPassword", "com.cognizant.entity.Manager.managerStatus.pending");
		}
		else if(managerAuth==3)
		{
			arg1.rejectValue("managerPassword", "com.cognizant.entity.Manager.managerStatus.rejected");
		}
		}
	}

}
