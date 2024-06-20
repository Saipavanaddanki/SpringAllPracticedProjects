package com.nit.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Address")
public class Address {
	@Id
	private int pincode;
	private String city;
	private String street;
	@Override
	public String toString() {
		return city+" "+street+" "+pincode;
	}
}
