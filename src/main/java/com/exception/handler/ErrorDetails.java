package com.exception.handler;

import java.io.Serializable;
import java.util.Date;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author Kuldeep
 *
 */
public class ErrorDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8462510196014227084L;
	private Date timestamp;
	private String message;
	private String details;
	private HttpStatus httpStatus;
	private String trackId;

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public ErrorDetails(Date timestamp, String message, String details, HttpStatus httpStatus) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.httpStatus = httpStatus;
	}

	public ErrorDetails(Date timestamp, String message, String details, HttpStatus httpStatus, String trackId) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.httpStatus = httpStatus;
		this.trackId = trackId;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public String getTrackId() {
		return trackId;
	}

}