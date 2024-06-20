package com.nit.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.MethodNotAllowedException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class WelcomeRestController {

	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> displayNullPointerException(NullPointerException ex,HttpServletRequest req){
		System.out.println("ContextPath   : "+req.getContextPath());
		System.out.println(req.getLocalPort()+" "+req.getLocalName()+" "+req.getLocalAddr());
   
		return new  ResponseEntity<String>(ex.getMessage()+"   exception is Occured because you perform operation on null ",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
