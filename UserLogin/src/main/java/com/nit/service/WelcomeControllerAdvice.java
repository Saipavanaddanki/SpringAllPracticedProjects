package com.nit.service;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class WelcomeControllerAdvice {

	@ExceptionHandler(Exception.class)
	public String exception(Exception ex,HttpServletRequest req) {
		return ex.getLocalizedMessage();
	}
	
}
