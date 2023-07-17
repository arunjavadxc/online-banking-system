package com.banking.user.exception;

public class CreditCardException extends RuntimeException {
	
	public CreditCardException(String error) {
		super(error);
	}
}
