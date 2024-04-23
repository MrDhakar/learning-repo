package com.jaid.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

import com.jaid.jwt.service.MyUserDetailService;

@EnableWebSecurity
@Configuration
public class ApplicationSecurity extends WebSecurityConfiguration {
	
	@Autowired
	private MyUserDetailService userDetailService;
	
	@Autowired
	public void initialize(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDetailService);//.withUser("JAID").password("JAID").roles("USER");
	}

}
