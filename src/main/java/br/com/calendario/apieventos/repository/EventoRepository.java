package br.com.calendario.apieventos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.calendario.apieventos.models.Evento;
import br.com.calendario.apieventos.models.Usuario;

public interface EventoRepository extends CrudRepository<Evento, String>{
	
	Iterable<Evento> findByUsuario(Usuario usuario);
	
	Evento findByCodigo(long codigo);
}
