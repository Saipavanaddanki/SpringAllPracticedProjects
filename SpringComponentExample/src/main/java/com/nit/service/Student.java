package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class Student {
	private int sid;
	private String sname;
	private University university;
	
	public Student() {
		super();
		System.out.println("Student");
	}
	
	public Student(int sid, String sname, University university) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.university = university;
	}

	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public University getUniversity() {
		return university;
	}
	@Qualifier("getUniversity")
	@Autowired
	public void setUniversity(University university) {
		this.university = university;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", university=" + university + "]";
	}
	
	
}
