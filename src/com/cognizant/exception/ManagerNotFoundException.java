package com.cognizant.exception;

public class ManagerNotFoundException extends NullPointerException {

	private String message;
	
	public ManagerNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
