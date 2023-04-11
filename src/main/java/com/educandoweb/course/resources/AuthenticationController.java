package com.educandoweb.course.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.securityConfig.Login;
import com.educandoweb.course.securityConfig.Token;
import com.educandoweb.course.services.AuthenticationService;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping
	public ResponseEntity<Token> autenticar(@RequestBody Login login) {
		return ResponseEntity.ok().body(authenticationService.autenticar(login));
	}

}
