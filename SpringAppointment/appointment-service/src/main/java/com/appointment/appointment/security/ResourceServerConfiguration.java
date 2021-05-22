package com.appointment.appointment.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
//				.antMatchers("/appointments/**")
//				.hasRole("ADMIN")
				.anyRequest()
				.authenticated();

	}
}
