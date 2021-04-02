package com.academy.monika.restapp.exceptions;
public class CustomException extends RuntimeException {

  public CustomException(Long id) {
    super("Exception was thrown for obj with id : " + id);
  }
  public CustomException(String message) {
	    super(message);
	  }
}
