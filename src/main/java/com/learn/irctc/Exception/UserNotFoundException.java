package com.learn.irctc.Exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {
		
		super();
	}

	public UserNotFoundException(String message) {
		super(message);
	}

}
