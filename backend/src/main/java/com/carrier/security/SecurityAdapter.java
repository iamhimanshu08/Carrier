package com.carrier.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.carrier.service.UserServiceImpl;


@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
public class SecurityAdapter extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserServiceImpl service;

	@Autowired
	private PasswordEncoder encoder;

	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(encoder);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/users/register/**").permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilter(new AuthenticationFilter(authenticationManagerBean()));
		http.addFilterBefore(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		
		
		
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	
}
