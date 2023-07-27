package com.banking.transaction.Exceptions;

public class InsufficientBalance extends Exception {
    public InsufficientBalance(String s){
        super(s);
    }
}
