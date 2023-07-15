package com.banking.user.exception;

public class LoanException extends RuntimeException {
	
	public LoanException(String error) {
		super(error);
	}
}
