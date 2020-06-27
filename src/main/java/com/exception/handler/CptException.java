package com.exception.handler;

public class CptException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4542708090685028727L;

	ErrorDetails details;

	public ErrorDetails getDetails() {
		return details;
	}

	public void setDetails(ErrorDetails details) {
		this.details = details;
	}

	public CptException() {
		super();
	}

	public CptException(ErrorDetails details) {
		super();
		this.details = details;
	}

}
