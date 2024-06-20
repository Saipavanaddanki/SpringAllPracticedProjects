package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbServices {
	@Autowired
	Repository1 repo;
	
	public void insert() {
		Employee emp=new Employee();
		Address adr=new Address();
		emp.setEmployee_Id(102);
		emp.setEmployee_Name("saipavan");
		emp.setEmployee_Salary(300030);
	     adr.setAddress_City("Hyd");
	     adr.setAddress_Pincode(40020);
	     adr.setAddress_Street("vinodh");
	     emp.setAddress(adr);
	      repo.save(emp);
	     System.out.println("1 Row inserted ");
	}
}
