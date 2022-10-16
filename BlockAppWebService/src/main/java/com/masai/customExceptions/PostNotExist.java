package com.masai.customExceptions;

public class PostNotExist extends RuntimeException {

	public PostNotExist() {

	}

	public PostNotExist(String msg) {

		super(msg);
	}

}
