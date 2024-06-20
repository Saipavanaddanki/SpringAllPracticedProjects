package com.nit.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeController {

	@GetMapping(value="/view")
	public ResponseEntity<EmployeeDetails> display(@RequestBody EmployeeDetails emp ){
		RestTemplate template=new RestTemplate();
		String url="http://localhost:8888/Restapi/view";
		HttpEntity<EmployeeDetails> request=new HttpEntity<EmployeeDetails>(emp);
		ResponseEntity<EmployeeDetails> response=template.postForEntity(url,request,EmployeeDetails.class);
		return new ResponseEntity<EmployeeDetails>(response.getBody(),response.getStatusCode());
	}
	
	
}
