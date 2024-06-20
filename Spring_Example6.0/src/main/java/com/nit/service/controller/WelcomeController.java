package com.nit.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.service.UserRegistration;
import com.nit.service.UserRegistrationDto;
import com.nit.service.db.ServiceImp;

@RestController
public class WelcomeController {

	@Autowired
	ServiceImp service;
	
	@PostMapping(path="/register",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<UserRegistration> toInsertAndView(@RequestBody UserRegistrationDto user){
		return new ResponseEntity<UserRegistration>(service.insert(user),HttpStatusCode.valueOf(201));
	}
	
	@PostMapping(path="/viewBy/{userId}")
	public  ResponseEntity<List<UserRegistration>> toView(@PathVariable String userId){
		return new ResponseEntity<List<UserRegistration>>(service.viewById(userId),HttpStatusCode.valueOf(201));
	}
	
}
