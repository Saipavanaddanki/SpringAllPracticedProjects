package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Autowired
	ServiceImp service;
	@Autowired
	JwtController jwtController;
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping(value="/register",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> register(@RequestBody UserRegistrationDto user){
		System.out.println("1");
		return new ResponseEntity<String>(service.registerUser(user),HttpStatus.CREATED);
	}
	
	@PostMapping(value="/login",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserRegistration> login(@RequestBody UserRegistrationDto user ){
		UsernamePasswordAuthenticationToken usernamepasswordauthenticationtoken=new UsernamePasswordAuthenticationToken(user.getUserName(), user.getUserMobile());
	    authenticationManager.authenticate(usernamepasswordauthenticationtoken);
		String token=jwtController.createToken(user.getUserName());
		HttpHeaders header=new HttpHeaders();
		header.add("token", token);
		return new ResponseEntity<UserRegistration>(service.verify(user.getUserName()),header,HttpStatus.OK);
	}
	
	@GetMapping(value="/All",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserRegistration>> verify(){
		   
			return new ResponseEntity<List<UserRegistration>>(service.listOfUser(),HttpStatus.OK);
	}
}
