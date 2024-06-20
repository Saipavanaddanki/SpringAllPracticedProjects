package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Autowired
	ServiceImp service;
	@PostMapping(value="/register",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> register(@RequestBody UserRegistrationDto user){
		return new ResponseEntity<String>(service.register(user),HttpStatus.CREATED);
	}
	
	@GetMapping(value="/display",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserRegistration>> display(){
		return new ResponseEntity<List<UserRegistration>>(service.display(),HttpStatusCode.valueOf(200));
	}
	
	@PostMapping(value="/login",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserRegistration> login(@RequestBody UserRegistrationDto user){
		return new ResponseEntity<UserRegistration>(service.login(user),HttpStatus.OK);
	}
}
