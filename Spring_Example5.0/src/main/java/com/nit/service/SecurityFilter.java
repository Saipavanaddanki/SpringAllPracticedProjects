package com.nit.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter  extends OncePerRequestFilter{
	
	@Autowired
	JwtsController jwtcontroller;
	
	@Autowired
	UserDetailsService services;
	
	Logger logger=LoggerFactory.getLogger(SecurityFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
		String token=request.getHeader("Authorization");
		String userId=null;
		logger.info(token);
		if(token!=null) {
			userId=jwtcontroller.isTokenValidWithUserId(token);
			if(userId!=null &&  SecurityContextHolder.getContext().getAuthentication()==null) {
				UserDetails user=services.loadUserByUsername(userId);
				if(jwtcontroller.isTokenValid(user.getUsername(), token)) {
					UsernamePasswordAuthenticationToken usernamepasswordauthenticationtoken=
							new UsernamePasswordAuthenticationToken(user,null,null);
				   SecurityContextHolder.getContext().setAuthentication(usernamepasswordauthenticationtoken);
				   
				}
			}else {
				logger.info("userid is empty while creation of token");
			}
			
			
		}
		else {
			logger.info("Please come with valid token");
		}
		
		filterChain.doFilter(request, response);
	}

}
