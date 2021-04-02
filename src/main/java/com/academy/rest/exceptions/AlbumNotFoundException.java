package com.academy.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AlbumNotFoundException extends RuntimeException {
    public AlbumNotFoundException(String message){
        super(message);
    }
}
