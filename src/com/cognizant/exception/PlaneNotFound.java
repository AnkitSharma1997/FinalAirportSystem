package com.cognizant.exception;

public class PlaneNotFound extends NullPointerException {

	private String message;
	
	public PlaneNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
