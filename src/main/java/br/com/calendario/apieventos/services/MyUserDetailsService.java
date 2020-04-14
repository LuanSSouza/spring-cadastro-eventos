package br.com.calendario.apieventos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.calendario.apieventos.models.Usuario;
import br.com.calendario.apieventos.repository.UsuarioRepository;
import br.com.calendario.apieventos.security.UsuarioSecurity;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		UsuarioSecurity usuario = usuarioService.findUsuarioSecurityByLogin(login);
		if (usuario == null) throw new UsernameNotFoundException("Usuário não encontrado!");
		
		return usuario;
	}

}
