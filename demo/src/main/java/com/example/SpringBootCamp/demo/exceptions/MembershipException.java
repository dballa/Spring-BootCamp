package com.example.SpringBootCamp.demo.exceptions;

public class MembershipException extends RuntimeException{
    public MembershipException(String message) {
        super(message);
    }
}
