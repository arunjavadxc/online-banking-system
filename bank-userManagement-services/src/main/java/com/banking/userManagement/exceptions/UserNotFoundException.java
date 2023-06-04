package com.banking.userManagement.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String a) {
        super(a);
    }
}
