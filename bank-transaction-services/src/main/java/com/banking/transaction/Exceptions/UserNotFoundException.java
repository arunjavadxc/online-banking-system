package com.banking.transaction.Exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String a) {
        super(a);
    }
}
