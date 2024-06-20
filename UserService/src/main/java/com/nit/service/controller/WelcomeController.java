package com.nit.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.service.dtoclasses.UserRegistrationDto;
import com.nit.service.security.JwtsController;
import com.nit.service.serviceimp.Servicess;
import com.nit.service.serviceimp.UserRegistration;

@RestController
public class WelcomeController {

	@Autowired
	Servicess service;
	@Autowired
	JwtsController jwtscontroller;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	@PostMapping(path="/viewAll",produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<UserRegistration>> toRetrive(){
		return new ResponseEntity<List<UserRegistration>>(service.retriveAll(),HttpStatus.CREATED);
	}
	
	@PostMapping(path="/login")
	public ResponseEntity<String> login(@RequestBody UserRegistrationDto user ){
		HttpHeaders headers=new HttpHeaders();
		UsernamePasswordAuthenticationToken usernamepasswordauthenticationtoken=
				new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
		authenticationManager.authenticate(usernamepasswordauthenticationtoken);
		String token=jwtscontroller.createToken(user.getEmail());
		headers.add("Authorization", token);
		return new ResponseEntity<String>(service.login(user),headers,HttpStatus.CREATED);
	}
	
	@PostMapping(path="/createUser")
	public ResponseEntity<String> createUser(@RequestBody UserRegistrationDto user){
		return new ResponseEntity<String>(service.createUser(user),HttpStatus.OK);
	}
	
	@Value("${contact.email}")
	String email;
	
	@GetMapping(value="/email")
	public String getEmail() {
		return email;
	}
}
