package com.nit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	Logger logger=LoggerFactory.getLogger(WelcomeController.class);
	
	@Autowired
	JwtComponent  jwtcontroller;
	@GetMapping(value="/view/{userId}")
	public String view(@PathVariable(name="userId") String userId) {
		return jwtcontroller.tokenCreation(userId);
		
	}
	
	@GetMapping(value="/isTokenValid/{userId}")
	public boolean isTokenValid(@PathVariable String userId,@RequestHeader String token) {
		logger.info(token);
		return jwtcontroller.tokenIsValidWithDate(token, userId) && jwtcontroller.tokenIsValidWithUserId(token, userId);
	}
	
}
