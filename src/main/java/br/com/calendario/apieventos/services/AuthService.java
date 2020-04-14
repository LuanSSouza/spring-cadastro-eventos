package br.com.calendario.apieventos.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import br.com.calendario.apieventos.models.Usuario;
import br.com.calendario.apieventos.utils.JwtUtil;

@Service
public class AuthService {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	public void authenticate(String username, String password) throws AuthenticationException {
		authenticationManager
			.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}
	
	public String generateToken(Usuario usuario) {
		return jwtUtil.generateUserToken(usuario);
	}
	
	public int extractId(HttpServletRequest request) {
		return jwtUtil.extractId(request.getHeader("Authorization").substring(7));
	}
}
