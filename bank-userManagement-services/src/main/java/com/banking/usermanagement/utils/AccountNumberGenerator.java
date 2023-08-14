package com.banking.usermanagement.utils;


import java.util.Random;

public class AccountNumberGenerator {
    private AccountNumberGenerator(){

    }
    public static String randomGenerator(){
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder(String.valueOf(Constants.IFSC));
        for(int i=0;i<6;i++)
            accountNumber.append(random.nextInt(9));
        return accountNumber.toString();
    }


}
