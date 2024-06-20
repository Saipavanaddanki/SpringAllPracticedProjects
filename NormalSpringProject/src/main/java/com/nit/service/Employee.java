package com.nit.service;

public class Employee {

	private int  employeeId;
	private String employeeName;
	public String toString() {
		return employeeId+"     "+employeeName;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
}
