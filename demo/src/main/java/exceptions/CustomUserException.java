package exceptions;

public class CustomUserException extends RuntimeException {
	
	private static final long serialVersionUID = -7884983183083899467L;

	public CustomUserException(String message) {
		    super(message);
		  }
	public CustomUserException(int id) {
	    super("Could not delete User with id: " + id);
	  }
}
