package com.nit.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class NormalSpringProjectApplication {

	public static void main(String[] args) {
	       ApplicationContext container=new FileSystemXmlApplicationContext("D:\\spring\\spring-workspace\\NormalSpringProject\\src\\main\\java\\com\\nit\\service\\General.xml");
	      Department dept1= (Department)container.getBean("dept");
	     Department dept2=(Department) container.getBean("dept2");
	      System.out.println(dept1);
	      System.out.println(dept2);
}
}