package com.nit.service.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class DbServices4 {

	@Autowired
	private Repository4 repo;
	
	public void insert() {
		Employee4 emp0=new Employee4();
		Employee4 emp1=new Employee4();
		Employee4 emp2=new Employee4();
		Department dept1=new Department();
		dept1.setDept_id(100);
		dept1.setDept_name("BackEnd");
		Department dept2=new Department();
		dept2.setDept_id(200);
		dept2.setDept_name("FrontEnd");
		emp0.setDept(dept2);
		emp0.setEid(1001);
		emp0.setEname("pavan");
		emp0.setSal(80009);
		emp1.setDept(dept1);
		emp1.setEid(1002);
		emp1.setEname("kiran");
		emp1.setSal(79979);
		emp2.setDept(dept2);
		emp2.setEid(1003);
	    emp2.setEname("sai");
	    emp2.setSal(90002);
	    repo.save(emp0);
	    repo.save(emp1);
	    repo.save(emp2);
	    System.out.println("Rows Are inserted");
	}
}
