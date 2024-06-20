package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
   
	@Autowired
	Servicess service;
	
//	@Value("${user.name}")
//	String name;
//	@Value("${user.email}")
//	String email;
//	@Value("${user.rollno}")
//	int no;
	@PostMapping(path="/register")
	public  ResponseEntity<String> display(@RequestParam String name,@RequestParam String email,@RequestParam int no){
		Register reg=new Register();
		
		reg.setUserName(name);
		reg.setUserEmail(email);
		reg.setUserNo(no);
		String result=service.insert(reg);
		return new ResponseEntity<String>(result,HttpStatus.CREATED);
	}
	@PostMapping(value="/select")
	public ResponseEntity<List<Register>> view(){
		return new ResponseEntity<List<Register>>(service.select(),HttpStatus.ACCEPTED);
	}
}
