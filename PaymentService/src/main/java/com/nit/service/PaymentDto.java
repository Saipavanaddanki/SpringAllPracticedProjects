package com.nit.service;

import lombok.Data;

@Data

public class PaymentDto {
	private int paymentId;
	private String paymentViaBank;
	private boolean status;
	private double amount;
}
