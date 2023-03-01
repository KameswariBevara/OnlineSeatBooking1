package com.capg.exception;

public class BookingNotFoundException extends RuntimeException{
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
//	String msg;
//
//	public BookingNotFoundException(String msg) {
//		super();
//		this.msg = msg;
//	}
//
//	public String getMsg() {
//		return msg;
//	}

public BookingNotFoundException(String message) {
	super(message);
}

	public Object getMsg() {
		// TODO Auto-generated method stub
		return null;
	}

}
