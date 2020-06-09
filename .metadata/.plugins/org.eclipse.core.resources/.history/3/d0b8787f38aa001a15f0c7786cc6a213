package com.security.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.jwt.moel.AuthenticationRequest;
import com.security.jwt.moel.AuthenticationResponse;
import com.security.jwt.service.MyUserDetailsService;
import com.security.jwt.util.JwtUtil;

@RestController
public class ResourceController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;

	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationResponse(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
					authenticationRequest.getPassword());
		} catch (BadCredentialsException e) {
			throw new Exception("Bad Credential!" +e.getMessage());
		}
		
		UserDetails userDetails =  userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		
		String token = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(token));
	}
}
