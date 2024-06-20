package com.nit.service.security;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.nit.service.serviceimp.ServiceImp;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	
	@Autowired
	JwtsController jwscontroller;
	
	@Autowired
	ServiceImp service;
	
	Logger logger=LoggerFactory.getLogger(SecurityFilter.class);
	
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
		String token=request.getHeader("Authorization");
		String userId=null;
		if(token!=null) {
			userId=jwscontroller.userIdFromToken(token);
			if(userId!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				UserDetails user=service.loadUserByUsername(userId);
				boolean isValidToken=jwscontroller.isValidToken(user.getUsername(), token);
				if(isValidToken) {
					UsernamePasswordAuthenticationToken usernamepasswordauthenticationtoken=
							new UsernamePasswordAuthenticationToken(user,null,null);
					SecurityContextHolder.getContext().setAuthentication(usernamepasswordauthenticationtoken);
				}
				else {
					logger.info("token is not a  valid one ,Please come with valid token");
				}
			}
			else {
				logger.info("invalid token with this user");
			}
		}
		else {
			logger.info("please come with token");
		}
		filterChain.doFilter(request, response);
	}

	
}
