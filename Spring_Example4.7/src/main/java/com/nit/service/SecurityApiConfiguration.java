package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityApiConfiguration {

	@Autowired
	SecurityFilter securityfilter;
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration .getAuthenticationManager();
	}
	
	@Bean
	public BCryptPasswordEncoder toBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain httpSecurity(HttpSecurity security) throws Exception {
		security.csrf(csrf->csrf.disable())
						.cors(cors->cors.disable())
						.authorizeHttpRequests(autorize->{
							autorize.requestMatchers("/login","/create")
							                 .permitAll()
							                 .anyRequest()
							                 .authenticated();
						})
						.addFilterBefore(this.securityfilter, UsernamePasswordAuthenticationFilter.class);
						
						return security.build();
	}
	
}
