package br.com.calendario.apieventos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.calendario.apieventos.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
	
	Usuario findByLogin(String login);
}
