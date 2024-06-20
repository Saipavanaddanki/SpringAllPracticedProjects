package com.nit.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class WelcomeController {

	@Autowired
	JwtController jwtcontroller;
	
	@GetMapping(path="/token/creation/{id}")
	public ResponseEntity<String> viewToken(@PathVariable String id,HttpServletRequest req) {
		HttpHeaders header=new HttpHeaders();
		header.add("id", id);
		
		return  new ResponseEntity<String>(jwtcontroller.createToken(id),header,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="/token/valid/{id}")
	public boolean validToken(@PathVariable String id,HttpServletRequest req) {
		String token=req.getHeader("token");
		System.out.println(token);
		return jwtcontroller.userIdValidation(id, token);
	}
}
