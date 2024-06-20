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
public class ServiceImp  implements UserDetailsService,Servicesss{

	@Autowired
	BCryptPasswordEncoder bcryptpasswordencoder;
	@Autowired
	Repository1 repo;
	@Override
	public String insert(UserRegistrationDto user) {
		List<Addresssess> list=new ArrayList<>();
		 user.getAddress().forEach(x->{
			 Addresssess adr=new Addresssess();
			 adr.setCity(x.getCity());
			 adr.setPincode(x.getPincode());
			 adr.setStreet(x.getStreet());
			 list.add(adr);
		 });
		 UserRegistration user1=new UserRegistration();
		 user1.setAddress(list);
		 user1.setEmail(user.getEmail());
		 user1.setMobile(user.getMobile());
		 user1.setName(user.getName());
		 user1.setPassword(bcryptpasswordencoder.encode(user.getPassword()));
		 repo.save(user1);
		return "Inserted Successfully";
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user=repo.findById(username).get();
		return user;
	}

}
