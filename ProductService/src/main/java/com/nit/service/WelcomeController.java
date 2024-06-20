package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
 
	@Autowired
	Servicess service;
	
	@Value("${contact.email}")
	String email;
	
	@PostMapping(path="/viewAll",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Orders>> viewAll(){
		return new ResponseEntity<List<Orders>>(service.viewAllOrders(),HttpStatusCode.valueOf(200));
	}
	
	@GetMapping(value="/trail")
	public String trail() {
		return "Helllo"+" "+email;
	}
}
