package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Autowired
	Servicess service;
	
	@PostMapping(value="/user")
	public String toInsert(@RequestBody UsersDto user) {
		return service.insert(user);
	}
	
	@PostMapping(value="/select",produces= {MediaType.APPLICATION_XML_VALUE})
	public List<Users> toDisplay(){
		return service.select();
	}
}
