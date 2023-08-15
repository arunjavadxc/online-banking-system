package com.banking.loans.Exceptions;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException(String a) {
        super(a);
    }
}
