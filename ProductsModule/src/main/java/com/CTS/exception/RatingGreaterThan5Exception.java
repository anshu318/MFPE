package com.CTS.exception;
/*
 * Custom Rating Greater Than 5 Exception 
 * */
public class RatingGreaterThan5Exception extends Exception {
	private static final long serialVersionUID = 1L;

	public RatingGreaterThan5Exception(String message) {
		super(message);
	}
}
