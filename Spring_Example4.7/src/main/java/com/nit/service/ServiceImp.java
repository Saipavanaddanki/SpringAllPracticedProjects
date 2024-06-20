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
public class ServiceImp implements Servicess,UserDetailsService{
	
	@Autowired
	Repository1 repository;
	@Autowired
	BCryptPasswordEncoder bcrptpasswordencoder;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserRegistration user=repository.findById(username).orElseThrow(()->new UsernameNotFoundException("Invalid userId"));
		return user;
	}


	@Override
	public String toInsert(UserRegistrationDto user) {
		 UserRegistration u1=new UserRegistration();
		 u1.setName(user.getName());
		 u1.setEmail(user.getEmail());
		 u1.setMobile(user.getMobile());
		 u1.setPassword(bcrptpasswordencoder.encode(user.getPassword()));
		 List<Addressess> adrlist=new ArrayList<>();
		 user.getAddress().forEach(x->{
			 System.out.println(x);
			  Addressess adr=new Addressess();
			  adr.setCity(x.getCity());
			  adr.setPincode(x.getPincode());
			  adr.setStreet(x.getStreet());
			  adrlist.add(adr);
		 });
		 u1.setAddressess(adrlist);
		 repository.save(u1);
		return "Inserted successfully   :   user   =>  "+u1.getEmail();
	}




}
