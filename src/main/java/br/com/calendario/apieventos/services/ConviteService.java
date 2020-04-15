package br.com.calendario.apieventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calendario.apieventos.error.exception.ObjectNotFoundException;
import br.com.calendario.apieventos.models.Convite;
import br.com.calendario.apieventos.models.ConviteCompositeKey;
import br.com.calendario.apieventos.models.Evento;
import br.com.calendario.apieventos.models.Usuario;
import br.com.calendario.apieventos.repository.ConviteRepository;

@Service
public class ConviteService {
	
	@Autowired
	private ConviteRepository repository;
	
	public Convite insert(Convite convite) {
		return repository.save(convite);
	}
	
	public Convite update(Convite convite) throws ObjectNotFoundException {
		ConviteCompositeKey keys = convite.getKeys();
		Convite obj = findByKeys(keys.getUsuario(), keys.getEvento());
		obj.setStatus(convite.getStatus());
		return repository.save(obj);
	}
	
	public Convite findByKeys(Usuario usuario, Evento evento) throws ObjectNotFoundException {
		Convite convite = repository.findByKeys(new ConviteCompositeKey(usuario, evento));
		if (convite == null) throw new ObjectNotFoundException("Convite não encotrado");
		return convite;
	}
	
	public List<Convite> findByEvento(Evento evento) throws ObjectNotFoundException {
		List<Convite> convites = repository.findByEvento(evento);
		if (convites.isEmpty()) throw new ObjectNotFoundException("Nenhum evento encotrado");
		return convites;
	}
	
	public List<Convite> findByUsuario(Usuario usuario) throws ObjectNotFoundException {
		List<Convite> convites = repository.findByUsuario(usuario);
		if (convites.isEmpty()) throw new ObjectNotFoundException("Nenhum evento encotrado");
		return convites;
	}
	
	public void delete(Convite convite) throws ObjectNotFoundException {
		ConviteCompositeKey keys = convite.getKeys();
		findByKeys(keys.getUsuario(), keys.getEvento());
		repository.deleteByKeys(new ConviteCompositeKey(keys.getUsuario(), keys.getEvento()));
	}
}
