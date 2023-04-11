package com.educandoweb.course.securityConfig;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class Login {
	
	private String email;
	
	private String senha;
	
	public UsernamePasswordAuthenticationToken toConvert() {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
