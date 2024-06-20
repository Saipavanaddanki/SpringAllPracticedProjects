package com.nit.service;

import org.springframework.stereotype.Component;

@Component
public class University {

	public int uid=1000891;
	public String universityName="Aditya Junior College";
	
	public University() {
		super();
		System.out.println("university");
	}
	@Override
	public String toString() {
		return "University [uid=" + uid + ", universityName=" + universityName + "]";
	}
	public int getUid() {
		return uid;
	}
	
	public String getUniversityName() {
		return universityName;
	}
	
	
}
