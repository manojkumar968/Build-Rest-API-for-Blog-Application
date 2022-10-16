package com.masai.customExceptions;

public class AllreadyDislike extends RuntimeException {

	public AllreadyDislike() {

	}

	public AllreadyDislike(String msg) {

		super(msg);
	}

}
