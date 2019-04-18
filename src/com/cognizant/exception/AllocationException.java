package com.cognizant.exception;

public class AllocationException extends NullPointerException {

	private String message;
	
	public AllocationException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
