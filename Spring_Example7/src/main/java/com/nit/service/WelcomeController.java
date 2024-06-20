package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@Autowired
	ServiceImp service;
	
	
	@ResponseBody
	@PostMapping(value="/retriveAllUsers")
	public ResponseEntity<List<UserRegistration>> retrive(){
		
		return new ResponseEntity<List<UserRegistration>>(service.retrive(),HttpStatusCode.valueOf(201));
	}
}
