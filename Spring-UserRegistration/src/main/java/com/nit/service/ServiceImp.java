package com.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImp {

	@Autowired
	UserRepository repository;
	
	public String insert(UserRegistrationDto user) {
		UserRegistration user1=new UserRegistration();
		user1.setUserId(user.getUserId());
		user1.setUserName(user.getUserName());
		user1.setUserSal(user.getUserSal());
		List<Address> addr=new ArrayList<>();
		user.getAddress().forEach(x->{
			Address add=new Address();
			add.setPincode(x.getPincode());
			add.setCity(x.getCity());
			add.setStreet(x.getStreet());
			addr.add(add);
		});
		user1.setAddress(addr);
		repository.save(user1);
	//   repository.insert(user1.getUserId(), user1.getUserName(), user1.getUserSal(), user1.getAddress());
//	    if(result>0){
		return "successfully inserted";
//	    }else {
//	    	return "Failed to Insert";
//	    }
	}
	
	public List< UserRegistration> getDataOfAllUser() {
		return repository.findAll();
	}
}
