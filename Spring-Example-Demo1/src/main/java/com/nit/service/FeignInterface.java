package com.nit.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("SPRING-EXAMPLE-DEMO2")
public interface FeignInterface {

	@GetMapping(value="/register/display",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserRegistration>> display();
	
	@PostMapping(value="/register/login",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserRegistration> login(@RequestBody UserRegistrationDto user);
}
