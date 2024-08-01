package com.nit.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@CrossOrigin(origins = "http://localhost:3000/")
class WelcomeController {

	@GetMapping(value="/display")
	public ResponseEntity<String> display(){
		return new ResponseEntity<String>("Display",HttpStatus.OK);
	}
	//@CrossOrigin(origins = "*")
	@ResponseBody
	@GetMapping(value="/get",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> get(){
		return new ResponseEntity<Student>(new Student(),HttpStatus.CREATED);
	}
}
