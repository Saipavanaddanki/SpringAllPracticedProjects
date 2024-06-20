package com.nit.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Address_Employee1R")
public class Address {
	@Id
	private int address_Pincode;
	private String address_City;
	private String address_Street;
}
