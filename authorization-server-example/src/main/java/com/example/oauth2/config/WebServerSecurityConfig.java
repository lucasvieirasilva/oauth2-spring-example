package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebServerSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
	        	.antMatchers("/login")
	        	.permitAll()
	        .anyRequest()
	        	.authenticated()
	        .and()
	        	.formLogin()
	        	.permitAll();
	}
}
