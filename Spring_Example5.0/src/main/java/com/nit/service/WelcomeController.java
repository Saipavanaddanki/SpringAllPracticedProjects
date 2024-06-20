package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Autowired
	JwtsController jwtscontroller;
	
	@Autowired
	Servicess service;
	@Autowired
	AuthenticationManager authenticationManager;
	@PostMapping(value="/login")
	public String login(@RequestBody UserRegistrationDto user) {
	   
		UsernamePasswordAuthenticationToken usernamepasswordauthenticationtoken=
				new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
		authenticationManager.authenticate(usernamepasswordauthenticationtoken);
		
		String token=jwtscontroller.tokenCreation(user.getEmail());
		
		return token;
	}
	
	@PostMapping(value="/create")
	public String create(@RequestBody UserRegistrationDto user) {
		return  service.insert(user);
	}
	
	@PostMapping(value="/info")
	public String userInfo(@RequestBody UserRegistrationDto user){
		return  user.getEmail();
	}
	
}
