package com.change.whenexecute.youchange;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Role_Employee_MM")
@Data
public class Role {
	@Id
	private int role_No;
	private String role_Name;
	
	@ManyToMany(mappedBy ="Roles",fetch = FetchType.LAZY)
	private List<Role> Roles;
}
