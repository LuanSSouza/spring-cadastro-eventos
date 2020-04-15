package br.com.calendario.apieventos.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calendario.apieventos.error.exception.ObjectNotFoundException;
import br.com.calendario.apieventos.models.Convite;
import br.com.calendario.apieventos.models.Evento;
import br.com.calendario.apieventos.models.Usuario;
import br.com.calendario.apieventos.services.AuthService;
import br.com.calendario.apieventos.services.ConviteService;

@RestController
@RequestMapping("/convite")
@CrossOrigin(origins="http://localhost:4200")
public class ConviteController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private ConviteService conviteService;
	
	@PostMapping
	public ResponseEntity<?> inserir(@RequestBody Convite convite) {
		return ResponseEntity.ok(conviteService.insert(convite));
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Convite convite) throws ObjectNotFoundException {
		return ResponseEntity.ok(conviteService.update(convite));
	}
	
	@GetMapping
	public ResponseEntity<?> listar(HttpServletRequest request) throws ObjectNotFoundException {	
		Usuario usuario = new Usuario(authService.extractId(request));
		return ResponseEntity.ok(conviteService.findByUsuario(usuario));
	}
	
	@GetMapping("/evento")
	public ResponseEntity<?> getByEvento(@RequestBody Evento evento) throws ObjectNotFoundException {
		return ResponseEntity.ok(conviteService.findByEvento(evento));
	}
	
	@PostMapping(value = "/deletar")
	public ResponseEntity<?> delete(@RequestBody Convite convite) throws ObjectNotFoundException {
		conviteService.delete(convite);
		return ResponseEntity.ok("Deletado com sucesso!");
	}

}
