package com.nit.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity()
@Table(name="Address_Details")
public class Addressess {

	private String city;
	private String street;
	@Id
	private int pincode;
}
