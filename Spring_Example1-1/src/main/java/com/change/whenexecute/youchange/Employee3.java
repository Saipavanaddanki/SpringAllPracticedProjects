package com.change.whenexecute.youchange;


import java.util.List;

import jakarta.persistence.CascadeType;

//import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Employee_Role_MM")
public class Employee3 {
	@Id
	private int employee_Id;
	private String employee_Name;
	private double employee_Salary;
	
	@ManyToMany(fetch =FetchType.LAZY,cascade=CascadeType.ALL)
//	@JoinTable(name = "Emp_Adr_2R",joinColumns = {@JoinColumn(name="E_Id")})
	private List<Role> Roles;

}
