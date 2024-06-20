
package com.nit.service;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="user_registration")
@Data
public class UserRegistration {

	@Id
	private int userId;
	private String userName;
	private double userSal;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinTable(name = "User_Address",joinColumns = {@JoinColumn(name="address_id")} )
	//@JoinColumn(name = "User_Address_Id")
	private List<Address> address;
}
