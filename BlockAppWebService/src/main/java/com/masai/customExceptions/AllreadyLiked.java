package com.masai.customExceptions;

public class AllreadyLiked extends RuntimeException {

	public AllreadyLiked() {

	}

	public AllreadyLiked(String msg) {
		super(msg);
	}

}
