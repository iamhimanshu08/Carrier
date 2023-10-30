package com.carrier.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthorizationFilter extends OncePerRequestFilter {


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (request.getServletPath().equals("/login") && (request.getServletPath().equals("/user/register"))) {
			filterChain.doFilter(request, response);
		} else {
			String header = request.getHeader("Authorization");
			System.out.print("Start");
			if (header != null && header.startsWith("Bearer ")) {
				System.out.println("header");
				try {
					Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
					String token = header.substring("Bearer ".length());
					JWTVerifier verifier = JWT.require(algorithm).build();
					DecodedJWT decode = verifier.verify(token);
					String email = decode.getSubject();
					UsernamePasswordAuthenticationToken auth_token = new UsernamePasswordAuthenticationToken(email,
							null, null);
					SecurityContextHolder.getContext().setAuthentication(auth_token);
					filterChain.doFilter(request, response);

				} catch (Exception e) {
					Map<String, String> error = new HashMap<>();
					error.put("Error_msg", e.getMessage());
					new ObjectMapper().writeValue(response.getOutputStream(), error);
				}

			} else {
				filterChain.doFilter(request, response);
			}
		}
	}

}
