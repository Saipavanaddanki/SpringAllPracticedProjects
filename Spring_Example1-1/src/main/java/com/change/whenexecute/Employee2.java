package com.change.whenexecute;


import java.util.List;

import jakarta.persistence.CascadeType;

//import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Employee_Address_2R")
public class Employee2 {
	@Id
	private int employee_Id;
	private String employee_Name;
	private double employee_Salary;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "Emp_Adr_2R",joinColumns = {@JoinColumn(name="E_Id")})
	private List<Address2> addresses;

}
