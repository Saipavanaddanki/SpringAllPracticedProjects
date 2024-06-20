package com.nit.service.paking;

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
	
	@PostMapping(path="/insert",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insert(@RequestBody EmployeeDto emp){
		return new ResponseEntity<String>(service.insert(emp),HttpStatusCode.valueOf(201));
	}
	
	@GetMapping(value="/retrive",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> retrive(){
		return new ResponseEntity<List<Employee>>(service.retrive(),HttpStatus.OK);
	}
	
}
