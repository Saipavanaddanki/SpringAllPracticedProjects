package com.nit.service.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.service.Addressess;
import com.nit.service.UserRegistration;
import com.nit.service.UserRegistrationDto;

@Service
public class ServiceImp  implements Servicess{

	@Autowired
	UserDb repository;
	@Override
	public UserRegistration insert(UserRegistrationDto user) {
	    UserRegistration userReg=new UserRegistration();
	    List<Addressess> list=new ArrayList<>();
	    user.getAddress().forEach(x->{
	    	Addressess adr=new Addressess();
	    	adr.setCity(x.getCity());
	    	adr.setStreet(x.getStreet());
	    	adr.setPincode(x.getPincode());
	    	list.add(adr);
	    	
	    });
	    userReg.setAddress(list);
	    userReg.setEmail(user.getEmail());
	    userReg.setMobile(user.getMobile());
	    userReg.setName(user.getName());
	    userReg.setPassword(user.getPassword());
	    repository.save(userReg);
	    UserRegistration userResult=repository.findById(userReg.getEmail()).get();
		return userResult;
	}
	
	public List<UserRegistration> viewById(String name) {
		 List<UserRegistration> list=repository.findAllByName(name);
		 return list;
	}

	private List<UserRegistration> viewAllByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
