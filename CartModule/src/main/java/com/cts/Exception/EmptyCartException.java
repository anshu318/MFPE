package com.cts.Exception;

public class EmptyCartException  extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmptyCartException(String msg) {
		super(msg);
	}
}
