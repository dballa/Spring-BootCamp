package com.countrycity.countrycity.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@Getter
@Setter
public class ExceptionTemplate {

    private String message;
    private Timestamp timestamp;

}
