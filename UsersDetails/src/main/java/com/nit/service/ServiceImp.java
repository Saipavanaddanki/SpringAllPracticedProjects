package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImp {
	@Autowired
	UserDb repository;
	
	public  UserDetails insertUser(UserDetailsDto user) {
		UserDetails user1=new UserDetails();
		user1.setEmail(user.getEmail());
		user1.setMobile(user.getMobile());
		user1.setPassword(user.getPassword());
		user1.setUserId(user.getUserId());
		user1.setUserName(user.getUserName());
		repository.save(user1);
		System.out.println(user1.getEmail()+"    Inserted Successfully");
		return repository.findById(user.getUserId()).get();
	}
	public UserDetails find(int userId) {
		return repository.findById(userId).get();
	}
}
