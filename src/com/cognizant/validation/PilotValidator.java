package com.cognizant.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.cognizant.model.PilotModel;

@Component
public class PilotValidator implements Validator
{

	private static final Logger logger = LoggerFactory.getLogger(PilotValidator.class);

	@Override
	public boolean supports(Class<?>arg0)
	{
		logger.info("----Pilot Model class in supports of Pilot Validator----");
		return arg0.equals(PilotModel.class);
	}
	
	@Override
	public void validate(Object arg0, Errors arg1)
	{
		logger.info("----Pilot Model class in validate of Pilot Validator----");
		PilotModel pilotModel=(PilotModel)arg0;
		ValidationUtils.rejectIfEmpty(arg1, "pilotLicenseNumber", "pilotLicenseNumber.required");
		ValidationUtils.rejectIfEmpty(arg1, "pilotAddressLine1", "pilotAddressLine1.required");
		ValidationUtils.rejectIfEmpty(arg1, "pilotAddressLine2", "pilotAddressLine2.required");
		ValidationUtils.rejectIfEmpty(arg1, "pilotCity", "pilotCity.required");
		ValidationUtils.rejectIfEmpty(arg1, "pilotState", "pilotState.required");
		ValidationUtils.rejectIfEmpty(arg1, "pilotZipCode", "pilotZipCode.required");
		ValidationUtils.rejectIfEmpty(arg1, "pilotSsn", "pilotSsn.required");
	}
}