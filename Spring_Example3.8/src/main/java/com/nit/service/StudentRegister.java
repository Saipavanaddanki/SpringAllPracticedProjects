package com.nit.service;

import lombok.Data;

@Data
public class StudentRegister {

	private int id;
	private String name;
	private  int age;
	private long phone;
	private Address address;
}
