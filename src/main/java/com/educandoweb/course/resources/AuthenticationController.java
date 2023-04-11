package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.securityConfig.Login;
import com.educandoweb.course.securityConfig.Token;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {
	
	
	
	@PostMapping
	public ResponseEntity<Token> autenticar(@RequestBody Login login) {
		
	}

}
