package com.congnizant.ecommerce.model;

public class StatusDTO {
	private String message;

	public StatusDTO() {
	}

	public StatusDTO(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
