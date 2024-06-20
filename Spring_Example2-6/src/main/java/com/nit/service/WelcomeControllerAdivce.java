package com.nit.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class WelcomeControllerAdivce {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> displayNullPointerException(NullPointerException ex,HttpServletRequest req){
		return new ResponseEntity<String>(ex.getLocalizedMessage()+"        hello sir please check             this to  "+req.getContextPath(),HttpStatus.CREATED);
	}
	
}
