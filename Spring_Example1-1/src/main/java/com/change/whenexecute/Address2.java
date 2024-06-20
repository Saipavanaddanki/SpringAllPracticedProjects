package com.change.whenexecute;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Address_Employee2R")
public class Address2 {
	@Id
	private int address_Pincode;
	private String address_City;
	private String address_Street;
}
