package com.nit.service.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;





@Component
public class JwtsController {

	private final String Secret_Key="ABCDefgh@#$";
	
	private final long Time_Limit=5*60*1000;
	
	public String createToken(String userId) {
		String token=Jwts.builder()
											.setSubject(userId)
											.setIssuedAt(new Date(System.currentTimeMillis()))
											.setExpiration(new Date(System.currentTimeMillis()+Time_Limit))
											.signWith(SignatureAlgorithm.HS256,Secret_Key)
											.compact();
		return token;
	}
	
	public boolean isValidToken(String userId,String token) {
		Jws<Claims> claims=Jwts.parser().setSigningKey(Secret_Key).parseClaimsJws(token);
		
		return claims.getBody().getSubject().equals(userId) && claims.getBody().getExpiration().after(new Date(System.currentTimeMillis()));
	}
	
	public String userIdFromToken(String token) {
		return Jwts.parser().setSigningKey(Secret_Key).parseClaimsJws(token).getBody().getSubject();
	}
}
