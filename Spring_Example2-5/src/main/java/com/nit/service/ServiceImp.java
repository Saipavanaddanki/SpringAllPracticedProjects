package com.nit.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ServiceImp  implements Services{

	private Repository1 repo=null;
	

     ServiceImp(Repository1 repo){
	this.repo=repo;
	System.out.println(repo);
    }
	
	@Override
	public void insert(String name,int id,double sal) {
		Employee emp=new Employee();
				emp.setEmployeeId(id);
				emp.setEmployeeName(name);
				emp.setEmployeeSal(sal);
			
		repo.save(emp);
		
	}

	@Override
	public void delete(int id) {
	  repo.deleteById(id);
		
	}
	@Override
	public void deleteAll(List<Integer> a) {
		repo.deleteAllById(a);
	}

}
