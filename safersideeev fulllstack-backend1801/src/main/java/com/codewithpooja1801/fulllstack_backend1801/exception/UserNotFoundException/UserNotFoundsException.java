package com.codewithpooja1801.fulllstack_backend1801.exception.UserNotFoundException;

public class UserNotFoundsException extends RuntimeException {
	  public UserNotFoundsException(Long id) {
	        super("Could not find user with id: " + id);
	    }
}
