package com.nit.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	@Autowired
	ServiceImp service;
	
	@RequestMapping(value="/insert",method = RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<String> register(@RequestBody UserRegistrationDto user){
		HttpHeaders header=new HttpHeaders();
		header.add("DateAndTimeOfResponse",LocalDateTime.now().toString());
		return new ResponseEntity<String>(service.insert(user),HttpStatusCode.valueOf(201));
	}
	
	@GetMapping(value="/display",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserRegistration>> displayAllUserInfo(){
		return new ResponseEntity<List<UserRegistration>>(service.getDataOfAllUser(),HttpStatus.OK);
	}
}
