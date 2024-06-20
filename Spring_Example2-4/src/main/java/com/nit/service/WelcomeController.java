package com.nit.service;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@PostMapping(path="/exception/check")
	public ResponseEntity<String> displayTheException( ){
		int i=0;
		int j=90;
		int c=j/i;
		return new ResponseEntity(c+" is the result",HttpStatusCode.valueOf(200));
	}
	
	@GetMapping(path="/exception")
	public String displayTheException2() {

		String s1=null;
	try {
		s1.equalsIgnoreCase("sai");
	}
	catch(NullPointerException e) {
		return e.getLocalizedMessage()+" from null pointer specific method";
		}
	catch(Exception e) {
		System.out.println(e.getLocalizedMessage());
		return e.getLocalizedMessage();
	}
	return s1;
	}
}
