package com.educandoweb.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.educandoweb.course.securityConfig.Login;
import com.educandoweb.course.securityConfig.Token;

@Service
public class AuthenticationService {
	
	@Autowired
	private TokenService tokenService;
	
	private AuthenticationManager authManager;
	
	public Token autenticar(Login loginData) {
		
		Authentication authentication = authManager.authenticate(loginData.toConvert());
		
		String token = tokenService.generateToken(authentication);
		
		
		return new Token(token, "Baarer");
	}

}
