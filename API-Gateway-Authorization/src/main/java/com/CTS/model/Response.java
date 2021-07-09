package com.CTS.model;

import java.io.Serializable;

public class Response implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private String jwttoken;

	private int customerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Response(String jwttoken, int customerId) {
		this.jwttoken = jwttoken;
		this.customerId = customerId;
	}

	public String getJwttoken() {
		return jwttoken;
	}

	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}

}
