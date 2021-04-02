package com.academy.rest.exceptions;

public class ArtistNotFoundException extends RuntimeException {
    public ArtistNotFoundException(String message){
        super(message);
    }
}
