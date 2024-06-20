package com.nit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	Logger logger=LoggerFactory.getLogger(WelcomeController.class);
	
	@PostMapping(value="/display")
	public  ResponseEntity<StudentRegister>  display(@RequestBody StudentRegister stredg) {
		logger.debug("reduest   "+stredg.getClass());
		logger.debug("display method started");
		logger.info("display method in progress");
		logger.trace("String return method");
		logger.info("successfully display method ending");
		return new ResponseEntity<StudentRegister>(stredg,HttpStatus.CREATED);
	}
}
