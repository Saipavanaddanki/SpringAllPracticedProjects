package com.nit.service;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtController {

	private final String Secret_Key="lkaajsklfeopwjdkei";
	public String createToken(String id) {
	  String token	=Jwts.builder().setSubject(id).setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()+5*60*1000)).signWith(SignatureAlgorithm.HS256, Secret_Key.getBytes())
		.compact();
		
		return token;
	}
	
	public boolean  userIdValidation(String id,String token) {
	Claims claims=	(Claims)Jwts.parser().setSigningKey(Secret_Key.getBytes()).parse(token).getBody();
	System.out.println(claims.getIssuedAt()+" "+claims.getExpiration()+" "+claims.getSubject());
		return id.equals(claims.getSubject());
	}
}
