package com.fssa.freshbye.validation.exceptions;

public class InvalidLikeException extends Exception{
	private static final long serialVersionUID = -2445894544830517976L;

	public InvalidLikeException(String msg) {
		super(msg);

	}

	public InvalidLikeException(Throwable e) {
		super(e);

	}
	public InvalidLikeException(String msg,Throwable e) {
		super(msg,e);

	}
}


