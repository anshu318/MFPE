package com.cognizant.ecommerce.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpClientErrorException;

import com.congnizant.ecommerce.model.ErrorResponseDto;

@ControllerAdvice
@Controller
public class CustomErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		return "error";
	}

	@ExceptionHandler({ HttpClientErrorException.class })
	public String globalException(HttpClientErrorException exception, HttpServletRequest request, Model m) {
		if (exception == null) {
			ErrorResponseDto dto = new ErrorResponseDto(new Date(), exception.getRawStatusCode(),
					HttpStatus.NOT_FOUND.getReasonPhrase(), "Unauthorized Access!!", request.getRequestURI());
			m.addAttribute("errorDto", dto);
			return "PageNotFound";
		}
		if (exception.getMessage().isBlank() || exception.getMessage().isEmpty()) {
			ErrorResponseDto dto = new ErrorResponseDto(new Date(), exception.getRawStatusCode(),
					HttpStatus.NOT_FOUND.getReasonPhrase(), "Unauthorized Access!!", request.getRequestURI());
			m.addAttribute("errorDto", dto);
			return "PageNotFound";
		}

		if (exception.getMessage().equalsIgnoreCase(
				"400 Cannot invoke \"com.congnizant.ecommerce.model.JwtResponse.getJwttoken()\" because \"this.jwtResponse\" is null")) {
			ErrorResponseDto dto = new ErrorResponseDto(new Date(), exception.getRawStatusCode(),
					HttpStatus.NOT_FOUND.getReasonPhrase(), "Unauthorized Access!!", request.getRequestURI());
			m.addAttribute("errorDto", dto);

		} else {
			ErrorResponseDto dto = new ErrorResponseDto(new Date(), exception.getRawStatusCode(),
					HttpStatus.NOT_FOUND.getReasonPhrase(), exception.getMessage(), request.getRequestURI());
			m.addAttribute("errorDto", dto);
		}

		return "PageNotFound";
	}

	@GetMapping("/error")
	public String getErrorPage(Model m, HttpServletRequest request) {

		ErrorResponseDto dto = new ErrorResponseDto(new Date(), 500, HttpStatus.NOT_FOUND.getReasonPhrase(),
				"Unknown Error Occured Please Trying LogIn Again", request.getRequestURI());
		m.addAttribute("errorDto", dto);
		return "PageNotFound";
	}

}
