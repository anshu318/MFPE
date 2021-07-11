package com.cts.Exception;

/*
 * Custom Empty Cart Exception
 * */
public class EmptyCartException  extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmptyCartException(String msg) {
		super(msg);
	}
}
