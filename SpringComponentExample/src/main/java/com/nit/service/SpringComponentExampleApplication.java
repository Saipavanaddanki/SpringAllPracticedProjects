package com.nit.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringComponentExampleApplication {

	public static void main(String[] args) {
	//SpringApplication.run(SpringComponentExampleApplication.class, args);
		AnnotationConfigApplicationContext container=new AnnotationConfigApplicationContext();
		/*
		 * container.register(); container.refresh();
		 */
		container.register(ConfigurationClass.class);
		container.refresh();
		container.scan("com.nit.service.Employee","com.nit.service.Student","com.nit.service.University");
		
		
		Employee emp=container.getBean(Employee.class);
		Student student=container.getBean(Student.class);
		University university=(University) container.getBean("getUniversity");
		System.out.println(university.hashCode());
		university=(University)container.getBean("getUniversity");
		System.out.println(university.hashCode());
		student.setSid(10022);
		student.setSname("sai");
		
		System.out.println(emp);
		System.out.println(student);
		

	}

}
