package com.educandoweb.course.securityConfig;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class Login {
	
	private String email;
	
	private String senha;
	
	public UsernamePasswordAuthenticationToken toConvert() {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}

}
