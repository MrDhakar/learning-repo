package com.jaid.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import com.jaid.gateway.IController.IJwtAuthController;
import com.jaid.gateway.model.UserData;
import com.jaid.gateway.response.JwtAuthTokenResponse;
import com.jaid.gateway.service.IMyUserDetailService;
import com.jaid.gateway.util.JwtTokenUtil;

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
