package br.com.calendario.apieventos.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calendario.apieventos.error.exception.ObjectNotFoundException;
import br.com.calendario.apieventos.models.Evento;
import br.com.calendario.apieventos.models.Usuario;
import br.com.calendario.apieventos.services.AuthService;
import br.com.calendario.apieventos.services.EventoService;


@RestController
@RequestMapping("/evento")
@CrossOrigin(origins="http://localhost:4200")
public class EventoController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private EventoService eventoService;
	
	@PostMapping
	public ResponseEntity<?> inserir(HttpServletRequest request, @RequestBody Evento evento) {
		Usuario usuario = new Usuario(authService.extractId(request));
		return ResponseEntity.ok(eventoService.insert(evento, usuario));
	}
	
	@GetMapping
	public ResponseEntity<?> listar(HttpServletRequest request) throws ObjectNotFoundException {	
		Usuario usuario = new Usuario(authService.extractId(request));
		return ResponseEntity.ok(eventoService.findByUsuario(usuario));
	}
	
	@GetMapping(value = "{codigo}")
	public ResponseEntity<?> getByCodigo(HttpServletRequest request, @PathVariable int codigo) throws ObjectNotFoundException {
		return ResponseEntity.ok(eventoService.findByCodigo(codigo));
	}
	
	@DeleteMapping(value = "{codigo}")
	public ResponseEntity<?> delete(@PathVariable int codigo) throws ObjectNotFoundException {
		eventoService.delete(codigo);
		return ResponseEntity.ok("Deletado com sucesso!");
	}
}
