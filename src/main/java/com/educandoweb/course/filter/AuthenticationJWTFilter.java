package com.educandoweb.course.filter;

import java.io.IOException;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.TokenService;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationJWTFilter extends OncePerRequestFilter{
	
	private TokenService tokenService;
	
	private UserRepository repository;
	
	

	public AuthenticationJWTFilter(TokenService tokenService, UserRepository repository) {
		this.tokenService = tokenService;
		this.repository = repository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
		String tokenJWT = recoverToken(request);

        if (tokenJWT != null) {

            User user = recoverUser(tokenJWT);

            Authentication authentication = new UsernamePasswordAuthenticationToken(user, null,
                    List.of(new SimpleGrantedAuthority(roleValidFormat(user))));

            SecurityContextHolder.getContext().setAuthentication(authentication);

        }

        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }

        return null;
    }

    private User recoverUser(String tokenJWT) {
        Long subject = Long.parseLong(tokenService.getSubject(tokenJWT));
        return repository.findById(subject).get();
    }

    private String roleValidFormat(User user) {
        return "ROLE_"+user.getAuthorities().toString().replace("[","").replace("]","");
    }

}
