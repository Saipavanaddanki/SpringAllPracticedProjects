package com.nit.service;


import jakarta.persistence.CascadeType;

//import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Employee_Address_1R")
public class Employee {
	@Id
	private int employee_Id;
	private String employee_Name;
	private double employee_Salary;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "Aid_Eid")
	private Address address;
}
