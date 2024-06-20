package com.nit.service;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtController {

	private final String Secret_Key="bddkdkeiuu&%$#;sksk";
	
	public String createToken(String userName) {
		String token=Jwts.builder().setSubject(userName).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+5*60*1000)).signWith(SignatureAlgorithm.HS256, Secret_Key).compact();
		return token;
	}
	
	public String getUserNameFromToken(String token) {
		String username=Jwts.parser().setSigningKey(Secret_Key).parseClaimsJws(token).getBody().getSubject();
		return username;
	}
	
	public boolean isValidToken(String Token,String username) {
		Claims claims=Jwts.parser().setSigningKey(Secret_Key).parseClaimsJws(Token).getBody();
		return username.equals(claims.getSubject()) && claims.getExpiration().after(new Date(System.currentTimeMillis()));
	}
}
