package com.masai.customExceptions;

public class CommentNotFoundInPost extends RuntimeException {

	public CommentNotFoundInPost() {

	}

	public CommentNotFoundInPost(String msg) {

		super(msg);
	}
}
