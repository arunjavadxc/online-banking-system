package com.banking.loans.Exceptions;

public class LessThanDueDate extends RuntimeException {
    public LessThanDueDate(String s){
        super(s);
    }
}
