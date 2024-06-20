package com.change.whenexecute;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbServices2 {
	@Autowired
	private Repository2 repo;
	
	public void insert() {
		Employee2 emp=new Employee2();
		Address2 adr0=new Address2();
		emp.setEmployee_Id(100);
		emp.setEmployee_Name("kiran");
		emp.setEmployee_Salary(32929);
		adr0.setAddress_City("Dubai");
		adr0.setAddress_Pincode(303030);
		adr0.setAddress_Street("kondak");
		Address2 adr1=new Address2();
		adr1.setAddress_City("banglore");
		adr1.setAddress_Pincode(50023);
		adr1.setAddress_Street("longdd");
		Address2 adr2=new Address2();
		adr2.setAddress_City("Hyd");
		adr2.setAddress_Pincode(102982);
		adr2.setAddress_Street("pakkuthi");
		emp.setAddresses(List.of(adr0,adr1,adr2));
		repo.save(emp);
	System.out.println("Inserted Successfully");

	}
	
}
