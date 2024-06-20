package com.nit.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@RequestMapping(path="user/header")
	public  ResponseEntity<String> displayHeaderAdditional(@RequestHeader(name="hostname") String hostname){
		HttpHeaders headers=new HttpHeaders();
		headers.add("serverMessage", hostname+ " hello client");
		return new ResponseEntity<String>("Successfully received your header from host:"+hostname,headers,HttpStatus.OK);
	}
	
	@Autowired
	Services service;
	
	
	@RequestMapping(path="user/insert/{Id}")
	public ResponseEntity<String> insert(@PathVariable int Id,@RequestParam String name,@RequestParam double sal){
		service.insert(name,Id,sal);
		return new ResponseEntity<String>("Successfull",HttpStatusCode.valueOf(201));
	}
	
	@RequestMapping(path="user/update/{Id}")
	public ResponseEntity<String> update(@PathVariable int Id,@RequestParam String name,@RequestParam double sal){
		service.insert(name,Id,sal);
		return new ResponseEntity<String>("Successfull",HttpStatusCode.valueOf(201));
	}
	
	@RequestMapping(path="user/delete/{Id}")
	public ResponseEntity<String> delete(@PathVariable int Id){
		service.delete(Id);
		return new ResponseEntity<String>("Successfull",HttpStatusCode.valueOf(201));
	}
	@RequestMapping(path="user/deleteAll/{Id}")
	public ResponseEntity<String> deleteAll(@PathVariable ArrayList<Integer> Id){
		service.deleteAll(Id);
		return new ResponseEntity<String>("Successfull",HttpStatusCode.valueOf(201));
	}
}
