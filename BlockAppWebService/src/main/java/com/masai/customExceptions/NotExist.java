package com.masai.customExceptions;

public class NotExist extends RuntimeException {

	public NotExist() {

	}

	public NotExist(String msg) {
		super(msg);
	}
}
