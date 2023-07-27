package com.banking.user.exception;

public class UserAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6137644757218128379L;

	public UserAlreadyExistException(String message) {
		super(message);
	}

}
