package com.nit.service.ManyToOne;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="employee_Depoartment_Mo")
@Data

public class Employee4 {

	@Id
	private int eid;
	private String ename;
	private double sal;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
//	@JoinTable(name="Dept_Employee",joinColumns= {@JoinColumn(name="id_eid",referencedColumnName = "eid")},
//	inverseJoinColumns = {@JoinColumn(name="id_dept",referencedColumnName = "dept_id")})
	@JoinColumn(name="Eid_Deptid")
	private Department dept;
}
