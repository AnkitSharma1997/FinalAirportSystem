package com.cognizant.exception;

public class HangarNotFound extends NullPointerException {

	private String message;
	
	public HangarNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
