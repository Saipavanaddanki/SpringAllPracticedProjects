package com.nit.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="emp_Details")
public class Employee {
private String employeeName;
@Id
private int employeeId;
private double employeeSal;
}
