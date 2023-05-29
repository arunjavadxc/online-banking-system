package com.banking.transaction.Exceptions;

import com.banking.transaction.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException {
    @ExceptionHandler(InsufficientBalance.class)
    public ResponseEntity<Response<String>> exNotFoundException(InsufficientBalance ib) {
        Response<String> response = new Response<>(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE.value(), ib.getLocalizedMessage());
        return new ResponseEntity<>(response, org.springframework.http.HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
    }
}
