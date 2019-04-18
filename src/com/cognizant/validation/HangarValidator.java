package com.cognizant.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.cognizant.model.HangarModel;

@Component
public class HangarValidator implements Validator
{
	private static final Logger logger = LoggerFactory.getLogger(HangarValidator.class);

	@Override
	public boolean supports(Class<?>arg0)
	{
		logger.info("----Hangar Model class in supports of Hangar Validator----");
		return arg0.equals(HangarModel.class);
	}
	
	@Override
	public void validate(Object arg0, Errors arg1)
	{
		logger.info("----Hangar Model class in validate of Hangar Validator----");
		HangarModel hangarModel=(HangarModel)arg0;
		ValidationUtils.rejectIfEmpty(arg1, "managerId", "managerId.required");
		ValidationUtils.rejectIfEmpty(arg1, "managerAddressLine1", "managerAddressLine1.required");
		ValidationUtils.rejectIfEmpty(arg1, "hangarCity", "hangarCity.required");
		ValidationUtils.rejectIfEmpty(arg1, "hangarState", "hangarState.required");
		ValidationUtils.rejectIfEmpty(arg1, "hangarZipCode", "hangarZipCode.required");
	}
}