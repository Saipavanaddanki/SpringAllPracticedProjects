package com.nit.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class WelcomeRestAdviser {

	
	@ExceptionHandler(ExpiredJwtException.class)
	public ResponseEntity<Boolean> exception(ExpiredJwtException ex,HttpServletRequest request){
		System.out.println(ex.getMessage());
		return new ResponseEntity<Boolean>(false,HttpStatus.CREATED);
	}
	
}
