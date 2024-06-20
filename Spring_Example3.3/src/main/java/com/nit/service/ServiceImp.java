package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImp implements Servicess {

	@Autowired
	Repository1 repo;
	@Override
	public String insert(UsersDto user) {
		Users u1=new Users();
		u1.setGender(user.getGender());
		u1.setUserId(user.getUserId());
		u1.setUserName(user.getUserName());
		u1.setUserSal(user.getUserSal());
	    repo.save(u1);
		return "Inserted Successfully";
	}
	
	public List<Users> select(){
	
		return repo.findAll();
	}

}
