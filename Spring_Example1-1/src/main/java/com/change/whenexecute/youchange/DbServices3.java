package com.change.whenexecute.youchange;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbServices3 {
	@Autowired
	private Repository3 repo;
	
	public void insert() {
		Employee3 emp1=new Employee3();
		Role role0=new Role();
		Role role1=new Role();
		Role role2=new Role();
		role0.setRole_No(1001);
		role0.setRole_Name("Dev");
		role1.setRole_Name("UI");
		role1.setRole_No(1002);
		role2.setRole_Name("DbAnalyst");
		role2.setRole_No(1003);
		
		emp1.setEmployee_Id(100);
		emp1.setEmployee_Name("kiran");
		emp1.setEmployee_Salary(32929);
		emp1.setRoles(List.of(role0,role1,role2));
		Employee3 emp2=new Employee3();
		emp2.setEmployee_Id(200);
		emp2.setEmployee_Name("kalyan");
		emp2.setEmployee_Salary(430302);
	    emp2.setRoles(List.of(role0,role1));
	
	    repo.save(emp1);
	    repo.save(emp2);
		
	
	System.out.println("Inserted Successfully");

	}
	
	public void searchEmployeeWithRoles() {
	Optional<Employee3> list=repo.findById(100);
		list.ifPresent((x)->{System.out.println(x);});
	}
	
}
