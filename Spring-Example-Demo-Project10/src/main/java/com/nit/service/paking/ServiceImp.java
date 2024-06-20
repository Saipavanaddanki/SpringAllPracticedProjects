package com.nit.service.paking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImp  {

	@Autowired
	EmployeeDb empDb;
	
	public String insert(EmployeeDto emp1) {
		Employee emp=new Employee();
		emp.setEmployeeId(emp1.getEmployeeId());
		emp.setEmployeeName(emp1.getEmployeeName());
		emp.setEmployeeSalary(emp1.getEmployeeSalary());
		empDb.save(emp);
		return "inserted Successfully";
	}
	
	public List<Employee> retrive(){
		ArrayList<Employee> arr=(ArrayList)empDb.findAll();
		arr.forEach(System.out::println);
		Comparator<Employee> cmp=(e1,e2)->{
			/*
			 * int sal1=(int) e1.getEmployeeSalary(); int sal2=(int)e2.getEmployeeSalary();
			 */
			return e1.getEmployeeName().compareTo(e2.getEmployeeName());
		};
		Collections.sort(arr,cmp);
		return  arr;
	}
	
}
