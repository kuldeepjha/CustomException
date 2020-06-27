package com.exception.handler;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * @author Kuldeep
 *
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> handleException(CustomException ex, Locale locale) {
		logger.debug("CoustomException");
		ErrorDetails errorDetails = new ErrorDetails(new Date(), Messaage.SFTP_EXC, ex.toString());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RuntimeCustomException.class)
	public ResponseEntity<Object> handleRuntimeException(RuntimeCustomException ex, Locale locale) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), Messaage.SFTP_EXC, ex.toString());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SqlCustomException.class)
	public ResponseEntity<Object> arithmeticExceptionhandle(SqlCustomException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), Messaage.SQL_EXC, ex.toString(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
