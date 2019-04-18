package com.cognizant.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.cognizant.model.PlaneModel;

@Component
public class PlaneValidator implements Validator
{

	private static final Logger logger = LoggerFactory.getLogger(PlaneValidator.class);

	@Override
	public boolean supports(Class<?>arg0)
	{
		logger.info("----Plane Model class in supports of Plane Validator----");
		return arg0.equals(PlaneModel.class);
	}
	
	@Override
	public void validate(Object arg0, Errors arg1)
	{
		logger.info("----Plane Model class in validate of Plane Validator----");
		PlaneModel planeModel=(PlaneModel)arg0;
		
		ValidationUtils.rejectIfEmpty(arg1, "ownerFirstName", "ownerFirstName.required");
		ValidationUtils.rejectIfEmpty(arg1, "ownerLastName", "ownerLastName.required");
		ValidationUtils.rejectIfEmpty(arg1, "ownerContactNo", "ownerContactNo.required");
		ValidationUtils.rejectIfEmpty(arg1, "ownerEmail", "ownerEmail.required");
		ValidationUtils.rejectIfEmpty(arg1, "planeType", "planeType.required");
		ValidationUtils.rejectIfEmpty(arg1, "planeCapacity", "planeCapacity.required");
	}
}