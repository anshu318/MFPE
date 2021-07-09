package com.CTS.controller;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.configure.Token;
import com.CTS.model.Request;
import com.CTS.model.Response;
import com.CTS.service.CustomDetails;

@RestController
public class ControlAuthenticator  {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private Token jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;
	@Autowired
	private CustomDetails jwtUserDetailsService;

	private static final Logger log = LoggerFactory.getLogger(ControlAuthenticator.class);
	
	@PostMapping("/authenticate")
	public ResponseEntity<Response> createAuthenticationToken(@RequestBody Request authenticationRequest)
			throws DisabledException, BadCredentialsException  {
		log.info("check 1");
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		
		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		
		final String tokens = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity
				.ok(new Response(tokens, jwtUserDetailsService.getUserId(authenticationRequest.getUsername())));
	}

	private void authenticate(String username, String password) {
		log.info("check 2");
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException ex) {
			throw new DisabledException("USER_DISABLED", ex);
		} catch (BadCredentialsException ex) {
			throw new BadCredentialsException("INVALID_CREDENTIALS", ex);
		}
	}
}