package com.nit.service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.service.Dto.CustomerRegDto;
import com.nit.service.Service.Services;

@RestController
public class WelcomeController {

	@Autowired
	Services serviceImp;
	
	@PostMapping(path="/Customer/registration",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public String  customerRegistration(@RequestBody CustomerRegDto cusdto) {
		
		return  serviceImp.insert(cusdto);
		//return cusdto.toString();
	}
	
	
}
