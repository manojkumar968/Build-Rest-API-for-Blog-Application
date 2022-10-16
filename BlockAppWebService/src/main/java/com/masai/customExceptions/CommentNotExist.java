package com.masai.customExceptions;

public class CommentNotExist extends RuntimeException {

	public CommentNotExist() {

	}

	public CommentNotExist(String msg) {
		
		super(msg);
	}
}
