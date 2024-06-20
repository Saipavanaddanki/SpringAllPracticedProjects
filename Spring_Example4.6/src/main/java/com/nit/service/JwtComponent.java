package com.nit.service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtComponent {
	private final String Secret_Key="abdcliskskei@39lsj;";
	Logger logger=LoggerFactory.getLogger(JwtComponent.class);
	public String tokenCreation(String userId) {
		String token=Jwts.builder().setSubject(userId).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+5*60*1000)).signWith(SignatureAlgorithm.HS256, Secret_Key).compact();
		return token;
	}
	
	public boolean tokenIsValidWithUserId(String token,String userId) {
		String uid=Jwts.parser().setSigningKey(Secret_Key).parseClaimsJws(token).getBody().getSubject();
		return uid.equals(userId);
	}
	
	public boolean tokenIsValidWithDate(String token,String userId) {
	 Date date=	Jwts.parser().setSigningKey(Secret_Key).parseClaimsJws(token).getBody().getExpiration();
	 logger.info("date with new Date()"+new Date());
	 logger.info("date: "+new Date().toLocaleString() );
	 logger.info(date+" \t \t"+System.currentTimeMillis());
		return date.after(new Date(System.currentTimeMillis()));
	}
}
