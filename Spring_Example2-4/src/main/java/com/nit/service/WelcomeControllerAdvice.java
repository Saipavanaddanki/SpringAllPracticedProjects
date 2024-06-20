
package com.nit.service;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class WelcomeControllerAdvice {

	@ResponseBody
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> exceptionCheck(ArithmeticException ex,HttpServletRequest req){
		return new ResponseEntity<String>(ex.getLocalizedMessage()+"   exception occur because you perform divide by zero",HttpStatusCode.valueOf(500));
	}
	
	
}
