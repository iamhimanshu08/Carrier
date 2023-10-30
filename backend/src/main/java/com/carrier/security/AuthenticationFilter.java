package com.carrier.security;

import java.io.IOException;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager manager;
	
	public AuthenticationFilter(AuthenticationManager manager) {
		this.manager = manager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		UsernamePasswordAuthenticationToken authenticatetoken = new UsernamePasswordAuthenticationToken(username, password);
		return manager.authenticate(authenticatetoken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		User user = (User)authResult.getPrincipal();
		Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
		String access_token = JWT.create()
				.withSubject(user.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+10*60*1000))
				.sign(algorithm);
		response.setHeader("access_token", access_token);
	}
	
	
}
