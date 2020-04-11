package br.com.calendario.apieventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.calendario.apieventos.models.AuthenticationRequest;
import br.com.calendario.apieventos.models.AuthenticationResponse;
import br.com.calendario.apieventos.services.MyUserDetailsService;
import br.com.calendario.apieventos.utils.JwtUtil;

@RestController
public class HomeController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/")
	public String home() {
		return "Hello World!";
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		//TODO Criar Hendler - Controller Advice para AuthenticationException
		try {
			authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());

		return ResponseEntity.ok(new AuthenticationResponse(jwtUtil.generateToken(userDetails)));
	}
}
