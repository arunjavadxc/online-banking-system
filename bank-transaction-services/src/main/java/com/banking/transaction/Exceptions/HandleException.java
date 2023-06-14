package com.banking.transaction.Exceptions;

import com.banking.transaction.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class HandleException {
    @ExceptionHandler(InsufficientBalance.class)
    public ResponseEntity<Response> exNotFoundException(InsufficientBalance ib) {
        Response response = new Response(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE.value(), ib.getLocalizedMessage(),new Date());
        return new ResponseEntity<>(response, org.springframework.http.HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
    }
}
