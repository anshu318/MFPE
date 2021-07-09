package com.CTS.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

}