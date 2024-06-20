package com.nit.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	Logger logg=LoggerFactory.getLogger(WelcomeController.class);
	
	@Autowired
	Services service;
	@PostMapping(value="/select")
	public ResponseEntity<List<LoginDto>> update() {
		logg.debug("successstart");
		logg.info("started info");
		logg.info("intermediate info");
		logg.trace("it is a select");
		return new ResponseEntity<List<LoginDto>>(service.select(),HttpStatusCode.valueOf(200));
	}
}
