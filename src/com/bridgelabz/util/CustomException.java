package com.bridgelabz.util;
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomException() {
		super("Oops! Something went wrong");
	}

	public CustomException(String errorMsg, Throwable error) {
		super(errorMsg, error);
	}

}