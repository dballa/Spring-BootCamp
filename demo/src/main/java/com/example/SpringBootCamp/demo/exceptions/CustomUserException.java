package com.example.SpringBootCamp.demo.exceptions;
public class CustomUserException extends RuntimeException {

  public CustomUserException(Long id) {
    super("Could not delete User with id: " + id);
  }
  public CustomUserException(String message) {
	    super(message);
	  }
}
