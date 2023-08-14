package com.banking.loans.Exceptions;

import com.banking.loans.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class HandleException {
    @ExceptionHandler(noLoanException.class)
    public ResponseEntity<Response> exnoLoanException(noLoanException nle) {
        Response response = new Response(HttpStatus.NOT_FOUND.value(), nle.getLocalizedMessage(),new Date());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(LoanNotFoundException.class)
    public ResponseEntity<Response> exLoanNotFoundException(LoanNotFoundException lfe) {
        Response response = new Response(HttpStatus.NOT_FOUND.value(), lfe.getLocalizedMessage(),new Date());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(LessThanDueDate.class)
    public ResponseEntity<Response> exLessThanDueDate(LessThanDueDate lfe) {
        Response response = new Response(HttpStatus.BAD_REQUEST.value(), lfe.getLocalizedMessage(),new Date());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
