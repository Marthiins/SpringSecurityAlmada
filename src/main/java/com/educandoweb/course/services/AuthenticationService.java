package com.educandoweb.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.educandoweb.course.securityConfig.Login;
import com.educandoweb.course.securityConfig.Token;
import org.springframework.security.core.AuthenticationException;

@Service
public class AuthenticationService {
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	public Token autenticar(Login loginData) {
		
		 try {
			 

	            Authentication authentication = authManager.authenticate(loginData.toConvert());
	            

	            String token = tokenService.generateToken(authentication);

	            return new Token(token , "Bearer");


	        } catch (AuthenticationException e) {
	            throw new RuntimeException("E-mail e / ou senha é / está errado | Ou sua conta está invativa");
	        }
		 

	}
	}
