package com.cts.Exception;

public class QuantityExcessException  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public QuantityExcessException(String msg) {
		super(msg);
	}

}
