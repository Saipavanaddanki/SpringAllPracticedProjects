package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
@Service
public class ServiceImp  implements Servicess{

	@Autowired
	Repository1 repo;
	@Override
	public List<UserRegistration> retrive() {
		
		return repo.retrive();
	}

}
