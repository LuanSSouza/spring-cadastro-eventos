package br.com.calendario.apieventos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.calendario.apieventos.models.Usuario;
import br.com.calendario.apieventos.repository.UsuarioRepository;
import br.com.calendario.apieventos.security.UsuarioSecurity;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario insert(Usuario usuario) {
		usuario.setId(null);
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		repository.save(usuario);
		usuario = repository.save(usuario);
		usuario.setSenha(null);
		return usuario;
		
	}
	
	public Usuario findByLogin(String login) {
		return repository.findByLogin(login);
	}
	
	public UsuarioSecurity findUsuarioSecurityByLogin(String login) {
		Usuario usuario = repository.findByLogin(login);
		return new UsuarioSecurity(usuario.getId(), usuario.getLogin(), usuario.getSenha());
	}
}
