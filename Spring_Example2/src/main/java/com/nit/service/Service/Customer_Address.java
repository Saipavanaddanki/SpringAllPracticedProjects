package com.nit.service.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="customer_Address")
public class Customer_Address {
private String Street;
private String City;
@Id
private String Drno;
}
