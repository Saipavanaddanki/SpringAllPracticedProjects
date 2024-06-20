package com.nit.service;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@Component
public class JwtsController {

	public final String Secret_key="ASLpsksjsk&*4<>sjsj#@!";
	
	public String createToken(String userId) {
		String user=Jwts.builder().setSubject(userId).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+5*60000))
				.signWith(SignatureAlgorithm.HS256, Secret_key).compact();
		System.out.println(user);
		return user;
	}
	
	public boolean isValidToken(String userId,String token) {
		Claims claims=Jwts.parser().setSigningKey(Secret_key).parseClaimsJws(token).getBody();
		System.out.println(claims.getSubject() +"   "+claims.getExpiration() );
		return claims.getSubject().equals(userId) && claims.getExpiration().after(new Date(System.currentTimeMillis()));
	}
	
	public String userIdFromToken(String token) {
		return Jwts.parser().setSigningKey(Secret_key).parseClaimsJws(token).getBody().getSubject();
	}
	
}
