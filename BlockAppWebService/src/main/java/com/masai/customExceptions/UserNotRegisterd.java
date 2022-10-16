package com.masai.customExceptions;

public class UserNotRegisterd extends RuntimeException {

	
	public UserNotRegisterd() {
		
	}
	
	public UserNotRegisterd(String msg) {
		
		super(msg);
	}
}
