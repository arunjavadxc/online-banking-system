package com.banking.user.utils;

import lombok.Data;

@Data
public class Response<T> {

	private int statusCode;
	private String message;
	private T responseObj;

}
