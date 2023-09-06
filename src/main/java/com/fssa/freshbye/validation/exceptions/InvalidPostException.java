package com.fssa.freshbye.validation.exceptions;

public class InvalidPostException extends Exception {
	
	/**
	 *  
	 */
	private static final long serialVersionUID = -2445894544830517976L;

	public InvalidPostException(String msg) {
		super(msg);

	}

	public InvalidPostException(Throwable e) {
		super(e);

	}
	public InvalidPostException(String msg,Throwable e) {
		super(msg,e);

	}
}
