package com.book.exception;

public class PublisherException extends RuntimeException {

	  public PublisherException(Long id) {
	    super("Could not delete Publisher with id: " + id);
	  }
	  public PublisherException(String message) {
		    super(message);
	  }
}

