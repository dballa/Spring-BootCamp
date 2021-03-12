package com.ikub.BarberApp;

public class UserExeption extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UserExeption(String message) {
        super(message);
    }
}
