package com.nit.service.paking;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class WelcomeControllerAdvicer {

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exception(Exception ex,HttpServletRequest req){
		return new ResponseEntity<String>(req.getContextPath()+"  "+"\n"+ex.getStackTrace(),HttpStatus.OK);
	}
}
