package com.jaid.jwt.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import com.jaid.jwt.api.IController.IJwtAuthController;
import com.jaid.jwt.api.model.UserData;
import com.jaid.jwt.api.response.JwtAuthTokenResponse;
import com.jaid.jwt.api.service.IMyUserDetailService;
import com.jaid.jwt.api.util.JwtTokenUtil;

@Controller
public class JwtAuthController implements IJwtAuthController {
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private IMyUserDetailService myUserDetailService;
	
	@Override
	public JwtAuthTokenResponse getJwtAuthToken(UserData userDataRequest) {
		// TODO Auto-generated method stub
		JwtAuthTokenResponse response = new JwtAuthTokenResponse();
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDataRequest.getUsername(), userDataRequest.getPassword()));
		
		final UserDetails userDetails=myUserDetailService.findByUsername(userDataRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		response.setToken(token);
		response.setUsername(userDetails.getUsername());
		return response;
	}

}
