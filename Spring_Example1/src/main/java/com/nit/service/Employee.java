package com.nit.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="employee_Details")
public class Employee {
	@Id
	private int eid;
	private String ename;
	private int sal;
}
