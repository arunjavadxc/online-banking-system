package com.banking.usermanagement.exceptions;

public class UserNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6075213044578383770L;

	public UserNotFoundException(String a) {
		super(a);
	}
}
