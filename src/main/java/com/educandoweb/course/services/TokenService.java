package com.educandoweb.course.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.educandoweb.course.entities.User;

@Service
public class TokenService {
	
	@Value("${jwt.expiration}")
	private String expiration;
	
	@Value("${jwt.expiration}")
	private String secret;

	public String generateToken(Authentication authentication) { // Usuario Logado
		
		User user = (User) authentication.getPrincipal();
		
		try {
			
			return JWT.create()
					.withIssuer("Spring Security")
					.withSubject(user.getId())
					.withIssuedAt(Instant.now())
			
		}
		
	}
	
}
