package com.olympiad.tokyo.exception;

public class CompetitonException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public CompetitonException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public CompetitonException() {
		super();
	}
}
