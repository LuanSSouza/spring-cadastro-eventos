package br.com.calendario.apieventos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.calendario.apieventos.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
	
	@Query(value = "SELECT * FROM usuario WHERE id <> ?1", nativeQuery = true)
	Iterable<Usuario> findAll(Usuario usuario);
	
	Usuario findByLogin(String login);
}
