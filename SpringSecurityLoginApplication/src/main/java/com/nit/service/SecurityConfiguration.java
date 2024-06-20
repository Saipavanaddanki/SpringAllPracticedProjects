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
public class SecurityConfiguration {
	
	@Bean
	public BCryptPasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager getAuthentication(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	@Autowired
	SecurityFilter securityfilter;
	
	@Bean
	public SecurityFilterChain security(HttpSecurity httpsecurity) throws Exception {
		                   httpsecurity.cors(cors->cors.disable())
				                                      .csrf(csrf->csrf.disable())
				                                      .authorizeHttpRequests(authorize->{
				                                      authorize.requestMatchers("/register","/login")
				                                      .permitAll()
				                                      .anyRequest()
				                                      .authenticated();
				                                      }).addFilterBefore(this.securityfilter, UsernamePasswordAuthenticationFilter.class);
				                                 
			
		return httpsecurity.build();
	}
	
}
