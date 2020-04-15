package br.com.calendario.apieventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calendario.apieventos.error.exception.ObjectNotFoundException;
import br.com.calendario.apieventos.models.Evento;
import br.com.calendario.apieventos.models.Usuario;
import br.com.calendario.apieventos.repository.EventoRepository;



@Service
public class EventoService {
	
	@Autowired
	private EventoRepository repository;
	
	public Evento insert(Evento evento, Usuario usuario) {
		evento.setCodigo(null);
		evento.setUsuario(usuario);
		return repository.save(evento);
	}
	
	public Evento update(Evento evento) throws ObjectNotFoundException {
		Evento obj = findByCodigo(evento.getCodigo());
		return repository.save(obj);
	}
	
	public List<Evento> findByUsuario(Usuario usuario) throws ObjectNotFoundException {
		List<Evento> eventos = repository.findByUsuario(usuario);
		if (eventos.isEmpty()) throw new ObjectNotFoundException("Nenhum evento encotrado");
		return eventos;
	}
	public Evento findByCodigo(int codigo) throws ObjectNotFoundException {
		Evento evento = repository.findByCodigo(codigo);
		if (evento == null) throw new ObjectNotFoundException("Evento não encotrado."); 
		return evento;
	}
	
	public void delete(int codigo) throws ObjectNotFoundException {
		findByCodigo(codigo);
		repository.deleteByCodigo(codigo);
	}
}
