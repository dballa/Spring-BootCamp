package com.book.exception;

public class BookException extends RuntimeException {

	  public BookException(Long id) {
	    super("Could not delete Book with id: " + id);
	  }
	  public BookException(String message) {
		    super(message);
	  }
}