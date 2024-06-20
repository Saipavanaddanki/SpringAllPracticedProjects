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
public class SecurityFilter  extends OncePerRequestFilter{

	@Autowired
	JwtsController jwtscontroller;
	
	@Autowired
	ServiceImp service;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		  
		     String token=request.getHeader("Authorization");     
		     System.out.println(token);
		     String userId=null;
		     if(token!=null) {
		    	 userId=jwtscontroller.userIdFromToken(token);
		    	 if(userId!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
		    		  
		    		  UserDetails user=service.loadUserByUsername(userId);
		    		  System.out.println(user.getUsername());
		    		  System.out.println(jwtscontroller.isValidToken(user.getUsername(), token));
		    		  if(jwtscontroller.isValidToken(user.getUsername(), token)) {
		    			  System.out.println("seting authentication");
		    			  UsernamePasswordAuthenticationToken usernamepasswordauthenticationtoken=new UsernamePasswordAuthenticationToken(user.getUsername(), null,null);  
		    			  SecurityContextHolder.getContext().setAuthentication(usernamepasswordauthenticationtoken);
		    		  }else {
		    			  System.out.println(" invalid token");
		    		  }
		    		  
		    		 
		    	 }
		     }
		     else {
		    	 System.out.println("please come with token");
		     }
		   
		     filterChain.doFilter(request, response);
	}

	
}
