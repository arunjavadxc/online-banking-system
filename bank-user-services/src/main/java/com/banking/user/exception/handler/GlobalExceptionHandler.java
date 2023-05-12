package com.banking.user.exception.handler;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.banking.user.exception.NotFoundException;
import com.banking.user.utils.Response;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Response<String>> exNotFoundException(NotFoundException nfe) {
		Response<String> response = new Response<>(HttpStatus.SC_NOT_FOUND, nfe.getLocalizedMessage(), null);
		return new ResponseEntity<>(response, org.springframework.http.HttpStatus.NOT_FOUND);
	}

}
