package com.banking.transaction.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<T> {

    private int statusCode;
    private String message;


}