package com.nit.service;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtController {

	private String Secret_Key="absncskflkjdfkl#@;";
	
	public String createToken(String userId) {
		String token=Jwts.builder().setSubject(userId)
				                   .setIssuedAt(new Date(System.currentTimeMillis()))
				                    .setExpiration(new Date(System.currentTimeMillis()+5*60*1000))
				                    .signWith(SignatureAlgorithm.HS256, Secret_Key)
				                    .compact();
		return token;
	}
	
	public String generateUserIdFromToken(String token) {
		return Jwts.parser().setSigningKey(Secret_Key).parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean isTokenValidWithUserIDAndDateOfExpire(String userId,String token) {
		
		Claims claims=Jwts.parser().setSigningKey(Secret_Key).parseClaimsJws(token).getBody();
		String userIdOriginal=claims.getSubject();
	   return (userId.equals(userIdOriginal)) && (claims.getExpiration().after(new Date()));
	}
}
