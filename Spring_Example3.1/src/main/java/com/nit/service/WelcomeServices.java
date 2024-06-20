package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WelcomeServices {

	@Autowired
	Repository1 repo;
	
	public void insert(Users user) {
		repo.save(user);
	}
}
