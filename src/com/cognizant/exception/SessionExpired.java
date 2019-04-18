package com.cognizant.exception;

public class SessionExpired extends NullPointerException {

	private String message;
	
	public SessionExpired(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
