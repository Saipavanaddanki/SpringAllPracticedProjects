package com.nit.service.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nit.service.dtoclasses.UserRegistrationDto;
@Service
public class ServiceImp implements Servicess,UserDetailsService{
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
	public List<UserRegistration> retriveAll() {
	  List<UserRegistration>  list =repository.findAll();
		return list;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return repository.findById(username).orElseThrow(()->new RuntimeException("Invalid Data"));
	}

	@Override
	public String createUser(UserRegistrationDto user) {
		UserRegistration userReg=new UserRegistration();
		userReg.setEmail(user.getEmail());
		userReg.setMobile(user.getMobile());
		userReg.setName(user.getName());
		userReg.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
	   List<Addressess> list=new ArrayList<>();
	   user.getAddress().forEach((x)->{
		   Addressess adr=new Addressess();
		   adr.setCity(x.getCity());
		   adr.setPincode(x.getPincode());
		   adr.setStreet(x.getStreet());
		   list.add(adr);
	   });
		userReg.setAddress(list);
		repository.save(userReg);
		return "Account Created Successfuly   Id  :"+userReg.getEmail();
	}

	@Override
	public String login(UserRegistrationDto user) {
		UserRegistration userReg= repository.findById(user.getEmail()).orElseThrow(()->new RuntimeException("Invalid UserId"));
		return "Login Successfully   "+userReg.getEmail();
	}

}
