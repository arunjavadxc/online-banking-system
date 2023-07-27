package com.banking.userManagement.exceptions;

import com.banking.userManagement.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class HandleException {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Response<String>> exNotFoundException(UserNotFoundException ib) {
        Response<String> response = new Response<>(HttpStatus.NOT_FOUND.value(), ib.getLocalizedMessage(),new Date());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
