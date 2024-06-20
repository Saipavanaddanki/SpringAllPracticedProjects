package com.nit.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Mobile_Store")
@Data
public class MobileStore {

	@Id
	private int mobileId;
	private String mobileName;
	private double price;


}
