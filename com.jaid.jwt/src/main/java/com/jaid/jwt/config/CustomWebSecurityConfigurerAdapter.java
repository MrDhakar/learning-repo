package com.jaid.jwt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/*@Configuration
@EnableWebSecurity*/
public class CustomWebSecurityConfigurerAdapter {

	@Autowired
	private RestAuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder().encode("user1Pass"))
				.authorities("ROLE_USER");
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(req -> req.requestMatchers("/securityNone").permitAll().anyRequest().authenticated())
				.httpBasic(httpSecurityHttpBasicConfigurer -> httpSecurityHttpBasicConfigurer
						.authenticationEntryPoint(authenticationEntryPoint));
		http.addFilterAfter(new JwtTokenFilter(), BasicAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}