package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	@Autowired
	ServiceImp service;

	@GetMapping(path="/create/retrive")
	public String insertAndRetrive(@RequestBody UserDetailsDto user) {
		return service.insertUser(user).toString();
	}
	@GetMapping(value="/finding/record/{userid}")
	public UserDetails FindById(@PathVariable int userid) {
		return service.find(userid);
	}
}
