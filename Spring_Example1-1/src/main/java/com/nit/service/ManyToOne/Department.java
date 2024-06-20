package com.nit.service.ManyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Dept_Employee_Mo")
public class Department {
	@Id
	private int dept_id;
	private String dept_name;
	
	

}
