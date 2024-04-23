package com.jaid.jwt.service;

/*@Component*/
public class JwtTokenFilter {
	/*
	 * @Autowired private JwtTokenUtil jwtTokenUtil;
	 * 
	 * @Autowired private UserDetailService myUserDetailService;
	 * 
	 * 
	 * public JwtTokenFilter(JwtTokenUtil jwtTokenUtil, UserRepo userRepo) {
	 * this.jwtTokenUtil = jwtTokenUtil; this.userRepo = userRepo; }
	 * 
	 * 
	 * @Override protected void doFilterInternal(HttpServletRequest request,
	 * HttpServletResponse response, FilterChain chain) throws ServletException,
	 * IOException { // Get authorization header and validate final String header =
	 * request.getHeader(HttpHeaders.AUTHORIZATION); if (isEmpty(header) ||
	 * !header.startsWith("Bearer ")) { chain.doFilter(request, response); return; }
	 * 
	 * // Get jwt token and validate final String token =
	 * header.split(" ")[1].trim(); if (!jwtTokenUtil.validate(token)) {
	 * chain.doFilter(request, response); return; }
	 * 
	 * // Get user identity and set it on the spring security context UserDetails
	 * userDetails = myUserDetailService
	 * .findByUsername(jwtTokenUtil.getUsername(token));
	 * 
	 * UsernamePasswordAuthenticationToken authentication = new
	 * UsernamePasswordAuthenticationToken( userDetails, null, userDetails == null ?
	 * List.of() : userDetails.getAuthorities() );
	 * 
	 * authentication.setDetails( new
	 * WebAuthenticationDetailsSource().buildDetails(request) );
	 * 
	 * SecurityContextHolder.getContext().setAuthentication(authentication);
	 * chain.doFilter(request, response); }
	 * 
	 * private boolean isEmpty(String header) { // TODO Auto-generated method stub
	 * return header==null || header.isEmpty(); }
	 * 
	 */}