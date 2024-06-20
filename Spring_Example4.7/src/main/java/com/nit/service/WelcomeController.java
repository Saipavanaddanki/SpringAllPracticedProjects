package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Autowired
	@Qualifier("authenticationManager")
	AuthenticationManager authenticationManager;

	
	@Autowired
	JwtController jwtcontroller;
	@Autowired
	ServiceImp service;
	@RequestMapping(value="/create")
	public String toDisplay(@RequestBody UserRegistrationDto user) {
		
		return service.toInsert(user);
	}
	
	@PostMapping(value="/login")
	public String login(@RequestBody UserRegistrationDto user) {
		UsernamePasswordAuthenticationToken usernamepasswordauthenticationtoken=new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
		try {
			authenticationManager.authenticate(usernamepasswordauthenticationtoken);
			}
		catch(Exception e) {
			return e.getMessage();
		}
		String token=jwtcontroller.createToken(user.getEmail());
		
	    return token;
	    }

	
	
}
