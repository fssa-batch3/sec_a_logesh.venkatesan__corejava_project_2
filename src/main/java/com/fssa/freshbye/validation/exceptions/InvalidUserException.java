package com.fssa.freshbye.validation.exceptions;

public class InvalidUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6504920749341860747L;

	public InvalidUserException(String msg) {
		super(msg);

	}

	public InvalidUserException(Throwable e) {
		super(e);

	}
 
} 
