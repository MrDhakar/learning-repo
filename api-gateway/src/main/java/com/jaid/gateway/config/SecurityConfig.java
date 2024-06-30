package com.jaid.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.jaid.gateway.service.JwtTokenFilter;


@Configuration
@EnableWebSecurity
/*
 * @EnableGlobalMethodSecurity( securedEnabled = true, jsr250Enabled = true,
 * prePostEnabled = true )
 */

@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private CustomAuthenticationProvider authProvider;
    
    @Autowired 
    private RestAuthenticationEntryPoint authenticationEntryPoint;
    
    
    @Autowired
    private JwtTokenFilter jwtTokentFilter;
    
    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
            http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authProvider);
        return authenticationManagerBuilder.build();
    }
    
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
/*        return http.authorizeHttpRequests(request -> request.requestMatchers("/rest/myapp/mytask")
        		.permitAll()
        		.anyRequest()
                .authenticated())
            .httpBasic(Customizer.withDefaults())
            .build();*/
        
        http.authorizeHttpRequests(req -> req.requestMatchers("/authtication/api/*").permitAll().
        		anyRequest().authenticated())
        .cors().and().csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.httpBasic(httpConfig -> httpConfig
				.authenticationEntryPoint(authenticationEntryPoint));
        http.addFilterBefore(jwtTokentFilter, BasicAuthenticationFilter.class);
        
		/*
		 * http.csrf() .disable() .authorizeRequests()
		 * .expressionHandler(customWebSecurityExpressionHandler())
		 * .antMatchers(HttpMethod.GET, "/roleHierarchy") .hasRole("STAFF");
		 */
          
        return http.build();
    }
    
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source =
            new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("localhost");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
    
    
    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String hierarchy = "ROLE_ADMIN > ROLE_STAFF \n ROLE_STAFF > ROLE_USER";
        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }
    
    @Bean
    public DefaultWebSecurityExpressionHandler customWebSecurityExpressionHandler() {
        DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
        expressionHandler.setRoleHierarchy(roleHierarchy());
        return expressionHandler;
    }
}