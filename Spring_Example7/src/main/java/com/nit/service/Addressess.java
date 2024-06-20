package com.nit.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="address_details")
public class Addressess {

	@Id
	private int pincode;
	private String city;
	private String street;
}
