package com.exception.handler;


import org.springframework.stereotype.Component;

/**
 * Create Custom exception, for custom configuration
 * 
 * @Author: Kuldeep
 *
 */
@Component
public class Messaage {

	public static final String FIELD_MISSING = "One of the required fields is missing";

	public static final String WRONG_INPUT = "Please enter right value";

	public static final String SQL_EXC = "Internal server error : Please try again later";

	public static final String SFTP_EXC = "Internal server error : Please try again later";

	public static final String PDF = "Internal server error : Please try again later";

	public static final String FILE_PATH = "File path is messing : Please try again later";

	public static final String SECURITY_EXC = "Security Exception";

	public static final String PICK_RECORD = "Record already picked";

	public static final String ROLE_RECORD = "role is link with user";

	Messaage() {

	}
}
