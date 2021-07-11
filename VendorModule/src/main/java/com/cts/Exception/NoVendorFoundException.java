package com.cts.Exception;

/*
 * Custom No Vendor Found Exception
 * */
public class NoVendorFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoVendorFoundException(String msg) {
		super(msg);
	}
}
