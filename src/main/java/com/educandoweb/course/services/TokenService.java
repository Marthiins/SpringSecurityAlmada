package com.educandoweb.course.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
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
					.withSubject(user.getId().toString())
					.withIssuedAt(Instant.now())
					.withExpiresAt(expirationInstant())
					.sign(secretAlgorithm());
			
		} catch(JWTCreationException exception) {
		  throw new RuntimeException("JWT ERROR");
		}
		
	}
	
	public String getSubject(String token) {
		
		return JWT.require(secretAlgorithm())
				.withIssuer("Spring Security")
				.build()
				.verify(token)
				.getSubject();
	
	}
	
	private Instant expirationInstant() {
		return LocalDateTime.now().plusHours(Long.parseLong(expiration)).toInstant(ZoneOffset.of("03-00"));
	}
	
	private Algorithm secretAlgorithm() {
		return Algorithm.HMAC256(secret);
	}
	
}
