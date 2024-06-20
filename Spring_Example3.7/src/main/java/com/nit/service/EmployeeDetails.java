package com.nit.service;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeeDetails {
private String status;
private ArrayList<Data> data;
private String message;
}
