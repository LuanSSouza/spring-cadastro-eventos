package br.com.calendario.apieventos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.calendario.apieventos.models.Convite;
import br.com.calendario.apieventos.models.ConviteCompositeKey;
import br.com.calendario.apieventos.models.Evento;
import br.com.calendario.apieventos.models.Usuario;

@Transactional
public interface ConviteRepository extends CrudRepository<Convite, String> {
	
	Convite findByKeys(ConviteCompositeKey keys);
	
	List<Convite> findByUsuario(Usuario usuario);
	
	List<Convite> findByEvento(Evento evento);
	
	void deleteByKeys(ConviteCompositeKey keys);
}
