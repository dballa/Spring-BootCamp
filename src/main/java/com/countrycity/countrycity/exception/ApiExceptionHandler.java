package com.countrycity.countrycity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({CountryException.class, CityException.class})
    public ResponseEntity<ExceptionTemplate> userExceptionHandler(Exception exception) {
        ExceptionTemplate template = new ExceptionTemplate();
        template.setMessage(exception.getMessage());
        template.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<>(template, HttpStatus.BAD_REQUEST);
    }


}
