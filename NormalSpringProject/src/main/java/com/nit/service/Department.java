package com.nit.service;

public class Department {

	private Employee emp1;
	private int departmentId;
	private String departmentName;
	public Department(int deptId,String deptName){
		this.departmentId=deptId;
		this.departmentName=deptName;
	}
	
	public void setEmp1(Employee emp1) {
		this.emp1 = emp1;
	}

	public String toString() {
		return emp1+" "+departmentId+ "  "+departmentName;
	}
}
