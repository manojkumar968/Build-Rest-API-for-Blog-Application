package com.masai.customExceptions;

public class UserAllreadyRegisterd extends RuntimeException {

	public UserAllreadyRegisterd(){
		
	}
	
	public UserAllreadyRegisterd(String msg){
		
		super(msg);
	}
}
