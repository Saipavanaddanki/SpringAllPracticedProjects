package com.nit.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter  extends OncePerRequestFilter{
	
	@Autowired
	JwtController jwtcontroller;
	
	@Autowired
	ServiceImp service;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token=request.getHeader("Authorization");
		String userId=null;
		if(token!=null) {
			userId=jwtcontroller.generateUserIdFromToken(token);
			if(userId!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				UserDetails user=service.loadUserByUsername(userId);
				boolean isTokenValid=jwtcontroller.isTokenValidWithUserIDAndDateOfExpire(user.getUsername(), token);
				if(isTokenValid) {
				//	UsernamePasswordAuthenticationFilter usernameandpasswordauthenticationfilter=new UsernamePasswordAuthenticationFilter();
					UsernamePasswordAuthenticationToken usernameandpasswordauthenticationtoken
					=new UsernamePasswordAuthenticationToken(user,null, null);
					SecurityContextHolder.getContext().setAuthentication(usernameandpasswordauthenticationtoken);
				}
				else {
					System.out.println("please come with valid token");
				}
				
			}
		}
		
		filterChain.doFilter(request, response);
		
				
	}

}
