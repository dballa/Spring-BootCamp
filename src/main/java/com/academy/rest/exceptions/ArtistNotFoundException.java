package com.academy.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ArtistNotFoundException extends RuntimeException {
    public ArtistNotFoundException(String message){
        super(message);
    }
}
