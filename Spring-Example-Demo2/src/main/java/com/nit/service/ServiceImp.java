package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ServiceImp {

	@Autowired
	UserRepository repository;
	
	public String register(UserRegistrationDto user){
		UserRegistration user1=new UserRegistration();
		user1.setEmail(user.getEmail());
		user1.setPassword(user.getPassword());
		user1.setUserId(user.getUserId());
		user1.setUserName(user.getUserName());
		repository.save(user1);
		return "User register Successfully";
	}
	
	public UserRegistration login(UserRegistrationDto user) {
		return repository.findByUserNameAndPassword(user.getUserName(),user.getPassword());
	}
	
	public List<UserRegistration> display(){
		return repository.findAll();
	}
}
