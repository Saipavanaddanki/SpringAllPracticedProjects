package com.nit.service;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class WelcomeControllerAdvicer {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exception(Exception ex,HttpServletRequest request){
	System.out.println("*************"+request.getServletContext()+" "+
		request.getServerName()+" "+
		request.getServerPort()+" "+
		request.getServletConnection()+"  "+
		request.getServletPath()+"*************");
	return new ResponseEntity<String>(ex.getLocalizedMessage(),HttpStatusCode.valueOf(505));
	}
}
