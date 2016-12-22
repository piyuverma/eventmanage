package com.event.exception;

public class CommonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int exceptionCode;

	public CommonException(Integer code, String message) {
		super(message);
		this.exceptionCode = code;
	}

	public CommonException(String message) {
		super(message);
	}

}
