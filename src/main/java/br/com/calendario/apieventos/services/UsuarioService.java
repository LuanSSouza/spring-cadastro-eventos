package br.com.calendario.apieventos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calendario.apieventos.models.Usuario;
import br.com.calendario.apieventos.repository.UsuarioRepository;
import br.com.calendario.apieventos.security.UsuarioSecurity;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario findByLogin(String login) {
		return repository.findByLogin(login);
	}
	
	public UsuarioSecurity findUsuarioSecurityByLogin(String login) {
		Usuario usuario = repository.findByLogin(login);
		return new UsuarioSecurity(usuario.getId(), usuario.getLogin(), usuario.getSenha());
	}
}
