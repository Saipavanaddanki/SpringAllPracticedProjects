package com.nit.service;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmpDto {

	@Min(value=20)
	private int empId;
	@NotBlank(message = "dont give null and empty")
    @Size(min = 3,message = "hello min three man")
	private String empName;
	@Max(value = 40000,message = "hello it crossed the maximum limit")
	private double empSal;
	
	@Email(message = "email syntax is missing bro please check once")
	private String empEmail;
}
