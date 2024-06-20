package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@RestController
public class WelcomeController {

	@Autowired
	UserFeignClient feignclients;
	@CircuitBreaker(name="USERLOGIN",fallbackMethod = "createOrderFailure")
	@GetMapping(value="/finding/{userid}")
	public  String FindById(@PathVariable int userid) {
	      
		return   feignclients.FindById(userid).toString();
		
	}
	
	public String createOrderFailure(Throwable ex){
		System.out.println(ex.getMessage());
		return "Order Service is Not Responding, Please Contact Support Team";
	}
	
	@CircuitBreaker(name="USERLOGIN",fallbackMethod="createResponseFailure")
	@PostMapping(value="/retrive")
	public String createAndRetrive(@RequestBody UserDetailsDto user) {
		return feignclients.insertAndRetrive(user);
	}
	
	public String createResponseFailure(Exception ex) {
		return "userdetails create response is failure";
	}
}
