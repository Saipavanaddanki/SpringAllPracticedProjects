package com.nit.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@RequestMapping(path="/Register",method=RequestMethod.POST,consumes=MediaType.APPLICATION_XML_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserLinkDto> usersData(@RequestBody UserLinkDto user,@RequestHeader String hostname) {
		System.out.println(user.toString());
		HttpHeaders header=new HttpHeaders();
		header.add("message", hostname+"  hii Gurru");
		return new ResponseEntity<UserLinkDto>(user,header,HttpStatusCode.valueOf(201));
		
	}
	
	@GetMapping(path="/operation/{operator}")
	public  int operation(@PathVariable String operator,@RequestParam String n1,@RequestParam(required=false) String n2) {
		return switch(operator) {
		case "mul":
			int l1=n1.length();
			int l2=n2.length();
			yield(l1*l2 );
			
		case "div":
			int l3=n1.length();
			int l4=n2.length();
			yield(l3/l4);
		
		default:
			yield(-1);
			
		};
	}
	
	
	
	
}
