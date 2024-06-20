package com.nit.service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="login")
@Data
public class Login {
	@Id
	@Column(name="USERID")
	private int userId;
	@Column(name="USERNAME")
	private String userName;
	@Column(name="USERSAL")
	private double userSal;
}
