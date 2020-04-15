package br.com.calendario.apieventos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.calendario.apieventos.models.Convite;
import br.com.calendario.apieventos.models.ConviteCompositeKey;
import br.com.calendario.apieventos.models.Evento;
import br.com.calendario.apieventos.models.Usuario;

@Transactional
public interface ConviteRepository extends CrudRepository<Convite, String> {
	
	Convite findByKeys(ConviteCompositeKey keys);
	
	@Query(value = "SELECT * FROM convite WHERE usuario_id = ?1", nativeQuery = true)
	List<Convite> findByUsuario(Usuario usuario);
	
	@Query(value = "SELECT * FROM convite WHERE evento_codigo = ?1", nativeQuery = true)
	List<Convite> findByEvento(Evento evento);
	
	void deleteByKeys(ConviteCompositeKey keys);
}
