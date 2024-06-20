package com.nit.service.paking;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Employee_table")
@Data
public class Employee {

	@Id
	private int employeeId;
	private String employeeName;
	private double employeeSalary;
}
