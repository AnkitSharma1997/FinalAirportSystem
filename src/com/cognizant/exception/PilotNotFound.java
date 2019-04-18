package com.cognizant.exception;

public class PilotNotFound extends NullPointerException {

	private String message;
	
	public PilotNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
