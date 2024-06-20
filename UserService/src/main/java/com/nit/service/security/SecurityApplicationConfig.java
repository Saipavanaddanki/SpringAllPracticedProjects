package com.nit.service.security;

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
public class SecurityApplicationConfig {
	
	@Autowired
	SecurityFilter securityFilter;
	
	@Bean
	public AuthenticationManager getManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	public BCryptPasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain httpSecurity(HttpSecurity security) throws Exception{
		security.csrf(csrf->csrf.disable())
						.cors(cors->cors.disable())
						.authorizeHttpRequests(authorize->{
							authorize.requestMatchers("/login","/createUser","/email")
												.permitAll()
												.anyRequest()
												.authenticated();
						})
						.addFilterBefore(this.securityFilter, UsernamePasswordAuthenticationFilter.class);
		return security.build();
	}
}
