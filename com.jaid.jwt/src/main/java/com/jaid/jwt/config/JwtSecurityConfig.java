package com.jaid.jwt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@EnableWebSecurity
@Configuration
public class JwtSecurityConfig extends WebSecurityConfiguration {
	/*
	 * 
	 * @Autowired private UserDetailService userDetailService;
	 * 
	 * @Autowired private JwtTokenFilter jwtTokenFilter;
	 * 
	 * 
	 * first step to build spring security
	 * 
	 * 
	 * @Autowired public void initialize(AuthenticationManagerBuilder builder)
	 * throws Exception {
	 * builder.userDetailsService(userDetailService);//.withUser("JAID").password(
	 * "JAID").roles("USER"); }
	 * 
	 * @Bean protected SecurityFilterChain configure(final HttpSecurity http, final
	 * AuthenticationManagerBuilder auth, final AuthenticationConfiguration
	 * authenticationConfiguration) throws Exception { // set the authentication
	 * provider auth.authenticationProvider(daoAuthenticationProvider());
	 * 
	 * // set the authorization and authentication rules return
	 * http.cors().and().disable() // Make sure that the session is stateless
	 * because weare using JWT
	 * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
	 * and(). // Add the JWT filter (my custom
	 * filter).addFilterBefore(jwtTokenFilter,
	 * UsernamePasswordAuthenticationFilter.class);
	 * .addFilter(jwtTokenFilter).build(); }
	 * 
	 * private AuthenticationProvider daoAuthenticationProvider() {
	 * 
	 * try { Authentication authenticate = authenticationManager.authenticate( new
	 * UsernamePasswordAuthenticationToken(request.getUsername(),
	 * request.getPassword()));
	 * 
	 * User user = (User) authenticate.getPrincipal();
	 * 
	 * return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,
	 * jwtTokenUtil.generateAccessToken(user))
	 * .body(userViewMapper.toUserView(user)); } catch (BadCredentialsException ex)
	 * { return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); } }
	 * 
	 * // TODO Auto-generated method stub return auth.userDetailsService(username ->
	 * myUserDetailService.loadUserByUsername(username));
	 * 
	 * }
	 * 
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception {
	 * 
	 * http.authorizeHttpRequests( (requests) -> requests.requestMatchers("/**",
	 * "/home").permitAll().anyRequest().authenticated())
	 * .cors().and().csrf().disable();
	 * 
	 * return http.build();
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * private Customizer<HttpBasicConfigurer<HttpSecurity>> withDefaults() {
	 * 
	 * return (T) -> { }; }
	 * 
	 * @Bean public WebSecurityCustomizer webSecurityCustomizer() { return (web) ->
	 * web.ignoring().requestMatchers("/resource", "/data").anyRequest(); }
	 * 
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { return
	 * NoOpPasswordEncoder.getInstance();
	 * 
	 * }
	 * 
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 * 
	 * @Bean public AuthenticationManager authenticationManagerBean() throws
	 * Exception { return super.authenticationManagerBean(); }
	 * 
	 *//**
		 * spring security authentication manager builder
		 * 
		 * @param auth
		 * @throws Exception
		 *//*
			 * @Bean protected void configure(AuthenticationManagerBuilder auth) throws
			 * Exception { auth.userDetailsService(username ->
			 * userDetailService.loadUserByUsername(username)); }
			 * 
			 * spring security for the http request
			 * 
			 * 
			 * @SuppressWarnings("removal")
			 * 
			 * @Bean protected void configure(HttpSecurity http) throws Exception { // TODO
			 * configure web security
			 * 
			 * // Enable CORS and disable CSRF http = http.cors().and().csrf().disable();
			 * 
			 * // Set session management to stateless http =
			 * http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
			 * STATELESS).and();
			 * 
			 * // Set unauthorized requests exception handler http =
			 * http.exceptionHandling().authenticationEntryPoint((request, response, ex) ->
			 * { response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
			 * }).and();
			 * 
			 * // Set permissions on endpoints http.authorizeHttpRequests() // Our public
			 * endpoints
			 * 
			 * .requestMatchers("/api/public/**").permitAll().requestMatchers(HttpMethod.
			 * GET, "/api/admin/**") .permitAll().requestMatchers(HttpMethod.POST,
			 * "/api/admin/search").permitAll() .requestMatchers(HttpMethod.GET,
			 * "/api/user/**").permitAll() .requestMatchers(HttpMethod.POST,
			 * "/api/user/search").permitAll() // Our private endpoints
			 * .anyRequest().authenticated();
			 * 
			 * // Add JWT token filter http.addFilterBefore(jwtTokenFilter,
			 * UsernamePasswordAuthenticationFilter.class);
			 * 
			 * }
			 * 
			 * // Used by Spring Security if CORS is enabled.
			 * 
			 * @Bean public CorsFilter corsFilter() { UrlBasedCorsConfigurationSource source
			 * = new UrlBasedCorsConfigurationSource(); CorsConfiguration config = new
			 * CorsConfiguration(); config.setAllowCredentials(true);
			 * config.addAllowedOrigin("*"); config.addAllowedHeader("*");
			 * config.addAllowedMethod("*"); source.registerCorsConfiguration("/**",
			 * config); return new CorsFilter(source); }
			 */
}
