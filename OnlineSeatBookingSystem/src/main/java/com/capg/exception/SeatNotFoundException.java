package com.capg.exception;

public class SeatNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;

	public SeatNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}

}
