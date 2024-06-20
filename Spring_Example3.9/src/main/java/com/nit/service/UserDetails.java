package com.nit.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@Component
public class UserDetails implements  InitializingBean,DisposableBean,ApplicationRunner,CommandLineRunner {

	
	Logger logger=LoggerFactory.getLogger(UserDetails.class);
	
	@Value("${name}")
	private String userName;
	@Value("${age}")
	private int userAge;
	@Value("${contact.email}")
	private String userEmail;
	@Value("${common}")
	private String common;
	
	
	@Override
	//@PostConstruct
	public void afterPropertiesSet() throws Exception {
		logger.debug("hello afterAllProperties Set is Started");
		logger.info("this method is in progress");
		logger.warn("Bean is initializing");
		logger.info("  Bean is created from"+this.getClass());
	
	}
	//@PreDestroy
	@Override
	public void destroy() {
		logger.info("Bean is destroying related to "+this.getClass());
	}
	@Override
	public void run(String... args) throws Exception {
			logger.info("Run methods from CommandlineRunner");
	        logger.info(Arrays.toString(args));
	        logger.info(args[1]);
	        logger.info("this is the method executed from "+this.getClass());
		
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
			logger.info("Run method ApplicationArguments"+" "+Arrays.toString(args.getOptionNames().toArray())+"       "+"this is the method executed from "+this.getClass());
		
	}
}
