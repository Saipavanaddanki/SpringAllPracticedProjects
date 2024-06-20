package com.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServiceImp  implements Servicess,UserDetailsService{

	@Autowired
	Repository1 repo;
	
	@Autowired
	BCryptPasswordEncoder bcryptpasswordencoder;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserDetails user= repo.findById(email).orElseThrow(()->new RuntimeException("Invalid Exception"));
		return user;
	}

	@Override
	public String insert(UserRegistrationDto user) {
		UserRegistration userRedg=new UserRegistration();
		List<Addressess> list=new ArrayList<>();
		user.getAddress().forEach((x)->{
			list.add(x);
		});
		userRedg.setName(user.getName());
		userRedg.setPassword(bcryptpasswordencoder.encode(user.getPassword()));
		userRedg.setEmail(user.getEmail());
		userRedg.setMobile(user.getMobile());
		userRedg.setAddress(list);
		
		repo.save(userRedg);
		return "inserted Successfully";
	}
	
	
}
