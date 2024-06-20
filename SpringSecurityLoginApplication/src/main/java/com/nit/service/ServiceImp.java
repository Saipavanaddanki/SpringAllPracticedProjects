package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServiceImp implements UserDetailsService{

	@Autowired
	UserRepository repository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public String registerUser(UserRegistrationDto user) {
		UserRegistration user1=new UserRegistration();
		user1.setUserId(user.getUserId());
		user1.setUserMobile(bcryptPasswordEncoder.encode(user.getUserMobile()));
		user1.setName(user.getUserName());
		System.out.println("2");
		repository.save(user1);
		System.out.println("3");
		return   user1.getUsername() +"Registered Successfully";
	}
	
	public UserRegistration verify(String id) {
		return repository.findByName(id);
	}

	public List<UserRegistration> listOfUser(){
		return repository.findAll();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return repository.findByName(username);
	}
	
}
