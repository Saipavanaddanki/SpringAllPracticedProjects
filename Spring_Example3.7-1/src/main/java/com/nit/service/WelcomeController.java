package com.nit.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@PostMapping(value="/view")
	public ResponseEntity<EmployeeDetails> display(@RequestBody EmployeeDetails emp ){
		
		return new ResponseEntity<EmployeeDetails>(emp,HttpStatus.OK);
	}
}
