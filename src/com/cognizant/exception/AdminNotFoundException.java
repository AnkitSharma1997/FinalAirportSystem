package com.cognizant.exception;

public class AdminNotFoundException extends NullPointerException {

	private String message;
	
	public AdminNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
