package com.exception.handler;

/**
 * 
 * @author kuldeep
 *
 */
public class RuntimeCustomException extends RuntimeException {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 8642895368076348766L;

	private ErrorDetails errorDetail;

	public ErrorDetails getErrorDetails() {
		return errorDetail;
	}

	public void setErrorDetails(ErrorDetails errorDetails) {
		this.errorDetail = errorDetails;
	}

}
