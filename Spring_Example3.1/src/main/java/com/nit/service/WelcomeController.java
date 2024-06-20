package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@Autowired
	WelcomeServices service;
	@ResponseBody
	@RequestMapping(path="/Register",consumes=MediaType.APPLICATION_XML_VALUE,produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Users> userDisplay(@RequestBody Users user) {
		service.insert(user);
		return new ResponseEntity<Users>(user,HttpStatusCode.valueOf(201));
	}
}
