package com.nit.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter{

	@Autowired
	JwtController jwtController;
	
	@Autowired
	ServiceImp service;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		 
		String token=request.getHeader("Authorization");
		if(token!=null ) {
			String username=jwtController.getUserNameFromToken(token);
			if(username!=null  && SecurityContextHolder.getContext().getAuthentication()==null) {
				UserDetails user=service.loadUserByUsername(username);
				if(jwtController.isValidToken(token, user.getUsername())) {
					UsernamePasswordAuthenticationToken usernamepasswordauthenticationtoken=new UsernamePasswordAuthenticationToken(user,null ,null);
					SecurityContextHolder.getContext().setAuthentication(usernamepasswordauthenticationtoken);
					
				}else {
					System.out.println("please come with token");
				}
				
			}
			else {
				System.out.println("please come with name");
			}
			
			
		}
		else {
			System.out.println("token is invalid");
		}
	         
		filterChain.doFilter(request, response);
	}

}
