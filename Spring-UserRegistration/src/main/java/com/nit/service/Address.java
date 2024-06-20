package com.nit.service;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="address_Details")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int addressId;
	private int pincode;
	private String city;
	private String street;
	
}
