package com.cts.Exception;

public class ProductIdNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ProductIdNotFoundException(String msg) {
		super(msg);
	}

}
