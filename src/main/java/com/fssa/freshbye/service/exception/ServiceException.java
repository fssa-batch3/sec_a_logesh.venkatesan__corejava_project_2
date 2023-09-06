package com.fssa.freshbye.service.exception;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2166346220002004434L;

	/**
	 * 
	 */
	
	public ServiceException(String msg) {
		super(msg);

	}
	
	public ServiceException(Throwable e) {
		super(e);

	}
	
	public ServiceException(String string, Throwable e) {
		super(e);

	}

}
