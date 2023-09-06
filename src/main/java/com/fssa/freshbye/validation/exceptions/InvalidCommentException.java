package com.fssa.freshbye.validation.exceptions;

public class InvalidCommentException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidCommentException(String msg) {
		super(msg);

	}

	public InvalidCommentException(Throwable e) {
		super(e);

	}
	public InvalidCommentException(String msg,Throwable e) {
		super(msg,e);

	}
}
