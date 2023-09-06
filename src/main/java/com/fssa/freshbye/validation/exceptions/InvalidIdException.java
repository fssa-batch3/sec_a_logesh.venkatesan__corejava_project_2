package com.fssa.freshbye.validation.exceptions;

public class InvalidIdException  extends Exception {
	private static final long serialVersionUID = -2445894544830517976L;

	public InvalidIdException(String msg) {
		super(msg);

	}

	public InvalidIdException(Throwable e) {
		super(e);

	}
	public InvalidIdException(String msg,Throwable e) {
		super(msg,e);

	}
}
