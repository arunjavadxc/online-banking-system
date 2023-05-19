package com.banking.user.exception.handler;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.banking.user.exception.NotFoundException;
import com.banking.user.exception.UserAlreadyExistException;
import com.banking.user.utils.Response;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Response<String>> exNotFoundException(NotFoundException nfe) {
		Response<String> response = new Response<>(HttpStatus.NOT_FOUND.value(), nfe.getLocalizedMessage(), null);
		return new ResponseEntity<>(response, org.springframework.http.HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SQLException.class)
	public ResponseEntity<Response<String>> sqlException(SQLException sqe) {
		Response<String> response = new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), sqe.getLocalizedMessage(),
				null);
		return new ResponseEntity<>(response, org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<Response<String>> userAlreadyExistException(UserAlreadyExistException uae) {
		Response<String> response = new Response<>(HttpStatus.NOT_ACCEPTABLE.value(), uae.getLocalizedMessage(),
				null);
		return new ResponseEntity<>(response, org.springframework.http.HttpStatus.NOT_ACCEPTABLE);
	}

}
