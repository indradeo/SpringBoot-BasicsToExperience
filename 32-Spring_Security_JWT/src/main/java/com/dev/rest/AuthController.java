package com.dev.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.bind.AuthenticationRequest;
import com.dev.bind.AuthenticationResponse;
import com.dev.service.MyUserDetailsService;
import com.dev.util.JwtUtil;


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private MyUserDetailsService detailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager manager;
	
	@PostMapping("/login")
	public AuthenticationResponse login(@RequestBody AuthenticationRequest request) {
		this.doAuthentication(request.getUsername(),request.getPassword());
		
		final UserDetails userDetails=detailsService.loadUserByUsername(request.getUsername());
		
		String token=jwtUtil.generateToken(userDetails);
		AuthenticationResponse resp= new AuthenticationResponse();
		resp.setJwt(token);
		return resp ;
	}
	
	
	
	private void doAuthentication(String username, String password) {
		try {
			UsernamePasswordAuthenticationToken token= new UsernamePasswordAuthenticationToken(username, password);
			manager.authenticate(token);
		}catch(BadCredentialsException e) {
			throw new BadCredentialsException("Invalid Credentials");
		}
	
	}
	
	@ExceptionHandler(value = BadCredentialsException.class)
	public String exceptionHandler() {
		
		return "Invalid Username and Password !!";
	}
}
