package com.nit.service.Service;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Customer_Registration")
public class Customer_Reg {
	private String  customer_Name;
	@Id
	private String customer_Email;
	private Long customer_Phno;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Cus_Addr")
	private Customer_Address customer_Address;
}
