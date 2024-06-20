package com.nit.service;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeController {

	RestTemplate services=new RestTemplate();
	@RequestMapping(path="/register",method = RequestMethod.POST)
	public String  addingUserToDb(@RequestBody UsersDto user) {
		
		HttpEntity<UsersDto> request=new HttpEntity<>(user);
		
		
		
	ResponseEntity<String> responseeEntity=	services.exchange("http://localhost:9999/register/user",HttpMethod.POST,request,String.class);
		return responseeEntity.getBody();
	}
	
	@RequestMapping(path="/retrive",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Users>> toDisplay(){
	ResponseEntity response=services.exchange("http://localhost:9999/register/select", HttpMethod.POST,null,List.class);
	return  new ResponseEntity<List<Users>>((List<Users>) response.getBody(),HttpStatusCode.valueOf(201));
		
	}
}
