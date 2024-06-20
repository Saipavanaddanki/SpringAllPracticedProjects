package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Autowired
	ServiceImp service;
	@Autowired
	AuthenticationManager authentication;
	@Autowired
	JwtsController jwtController;
	
	@PostMapping(value="/login")
	public ResponseEntity<String> login(@RequestBody UserRegistrationDto user) {
		UsernamePasswordAuthenticationToken usernamepasswordauthenticationtoken
		=new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
		authentication.authenticate(usernamepasswordauthenticationtoken);
		HttpHeaders header=new HttpHeaders();
		header.add("token",jwtController.createToken(user.getEmail()) );
		return new ResponseEntity<String>("Token Created and check in headerss",header,HttpStatusCode.valueOf(201));
	}
	
	@PostMapping(value="/info")
	public String info() {
		return "Hello";
	}
}
