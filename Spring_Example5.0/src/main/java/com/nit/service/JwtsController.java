package com.nit.service;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtsController {

	private final String Secret_Key="ASLpsksjsk&*4<>sjsj";
	
	public String tokenCreation(String userId) {
		String token=Jwts.builder().setSubject(userId).setIssuedAt(new Date(System.currentTimeMillis()))
									.setExpiration(new Date(System.currentTimeMillis()+5*60000))
									.signWith(SignatureAlgorithm.HS256, Secret_Key)
									.compact();
		return token;
	}
	
	public boolean isTokenValid(String userId,String token) {
		Claims claims=Jwts.parser().setSigningKey(Secret_Key).parseClaimsJws(token).getBody();
		return claims.getSubject().equals(userId) && claims.getExpiration().after(new Date(System.currentTimeMillis()));
	}
	
	public String isTokenValidWithUserId(String token) {
		Claims claims=Jwts.parser().setSigningKey(Secret_Key).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}
	
}
