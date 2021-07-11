package com.cts.Dto;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
/*
 * Custom error response data transfer object
 * */
public class ErrorResponseDto {
	private Date timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
}
