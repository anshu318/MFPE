package com.cts.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
/*
 * Error Response Data Transfer Object
 * */
public class ErrorResponseDto {

	private Date timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
}
