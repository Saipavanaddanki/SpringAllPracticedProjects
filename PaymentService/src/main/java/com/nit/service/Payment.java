package com.nit.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="payment_details")
@Data
public class Payment {

	@Id
	private int paymentId;
	private String paymentViaBank;
	private boolean status;
	private double amount;
}
