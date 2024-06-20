package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class WelcomeController {

	@Autowired
	FeignInterface feignInterface;
	
	@RequestMapping(value="/display")
	public ResponseEntity<String> display(){
		return new ResponseEntity<String>("Hello",HttpStatus.OK);
	}
	
	@CircuitBreaker(name="SPRING-EXAMPLE-DEMO1",fallbackMethod="failure")
	@GetMapping(path="/view")
	public ResponseEntity<List<UserRegistration>> view(){
		ResponseEntity<List<UserRegistration>> response= feignInterface.display();
	   return  new  ResponseEntity<List<UserRegistration>>(response.getBody(),response.getStatusCode());
	}
	public String failure(Exception ex) {
		return "server is  under maintanance";
	}
	
	@CircuitBreaker(name="SPRING-EXAMPLE-DEMO1",fallbackMethod="fail")
	@PostMapping(path="/login",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserRegistration> login(@RequestBody UserRegistrationDto user){
		ResponseEntity<UserRegistration> response=feignInterface.login(user);
		return new ResponseEntity<UserRegistration>(response.getBody(),response.getStatusCode());
	}

	
	public String fail(Exception ex) {
		return "server is not working";
	}
}
