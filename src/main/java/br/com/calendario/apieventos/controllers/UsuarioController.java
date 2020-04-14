package br.com.calendario.apieventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calendario.apieventos.models.AuthenticationRequest;
import br.com.calendario.apieventos.models.AuthenticationResponse;
import br.com.calendario.apieventos.models.Usuario;
import br.com.calendario.apieventos.services.AuthService;
import br.com.calendario.apieventos.services.UsuarioService;


@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins="http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value = "/autenticar")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws AuthenticationException {
		authService.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		Usuario usuario = usuarioService.findByLogin(authenticationRequest.getUsername());
		return ResponseEntity.ok(new AuthenticationResponse(authService.generateToken(usuario)));
	}
}