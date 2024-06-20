package com.nit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class Application {
	Logger logger=LoggerFactory.getLogger(Application.class);
	
	@Bean()
	public UserDetails getUser() {
		return new UserDetails();
	}
	
	@Profile("Dev")
	@Bean()
	public UserDetails getUser1AtDev() {
		
		logger.info("it is bean that is from getUser1AtDev method  " +this.getClass());
		
		return new UserDetails();
	}

	@Profile("Sit")
	@Bean()
	public UserDetails getUser2AtSit() {
		logger.info("it is  bean that is from getUser2AtSit method   "+ this.getClass());
		return new UserDetails();
	}
	
	@Profile("Uat")
	@Bean()
	public UserDetails getUser3AtUat() {
		logger.info("it is  bean that is from getUserAtUat method   "+ this.getClass());
		return new UserDetails();
	}
	
	public static void main(String[] args) {
				ConfigurableApplicationContext container=SpringApplication.run(Application.class, args);
			System.out.println(	container.getBean("userDetails").toString());
//			System.out.println(container.getBean("getUser3AtUat").toString());
			//System.out.println(container.getBean("getUser2AtSit").toString());
			System.out.println(container.getBean("getUser1AtDev").toString());
			System.out.println(	container.getBean("getUser").toString());
	}

}
