package com.cognizant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author 768817
 * 
 * Initial Controller will manage front page operations
 */

@Controller
public class InitialController {

	private static final Logger logger = LoggerFactory.getLogger(InitialController.class);
	
	/*
	 * when session is expired restrict the allocation request
	 */
	
	@RequestMapping(value ="index.htm")
	public String main1(){
		logger.info("----Loading Main Page in Initial Controller----");
		return "main";
	}

	@RequestMapping(value ="main.htm")
	public String main(){
		logger.info("----Loading Main Page in Initial Controller----");
		return "main";
	}
}
