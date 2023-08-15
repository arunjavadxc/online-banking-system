package com.banking.usermanagement.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.banking.usermanagement.utils.Response;

@RestControllerAdvice
public class HandleException {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Response<String>> exNotFoundException(UserNotFoundException ib) {
		Response<String> response = new Response<>(HttpStatus.NOT_FOUND.value(), ib.getLocalizedMessage(), new Date());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
