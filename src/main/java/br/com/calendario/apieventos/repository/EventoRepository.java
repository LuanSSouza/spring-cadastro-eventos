package br.com.calendario.apieventos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.calendario.apieventos.models.Evento;
import br.com.calendario.apieventos.models.Usuario;

@Transactional
public interface EventoRepository extends CrudRepository<Evento, String> {
	
	List<Evento> findByUsuario(Usuario usuario);
	
	@Query(value = "SELECT * FROM evento LEFT JOIN  convite ON convite.evento_codigo = evento.codigo"
			+ " WHERE evento.usuario_id = ?1 OR (convite.usuario_id = ?1 AND convite.status_id = 2)", 
			nativeQuery = true)
	List<Evento> findByUsuarioEventos(Usuario usuario);
	
	Evento findByCodigo(int codigo);
	
	void deleteByCodigo(int codigo);
}
