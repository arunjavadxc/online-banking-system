package com.banking.loans.Exceptions;

public class noLoanException extends RuntimeException {
    public noLoanException(String noLoanToRepay) {super(noLoanToRepay);}
}
