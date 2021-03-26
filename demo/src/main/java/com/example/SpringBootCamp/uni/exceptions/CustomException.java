package com.example.SpringBootCamp.uni.exceptions;
public class CustomException extends RuntimeException {

  public CustomException(Long id) {
    super("Could not delete User with id: " + id);
  }
  public CustomException(String message) {
	    super(message);
	  }
}
