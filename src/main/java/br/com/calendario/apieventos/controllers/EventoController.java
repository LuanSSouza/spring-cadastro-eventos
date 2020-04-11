package br.com.calendario.apieventos.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calendario.apieventos.models.Evento;
import br.com.calendario.apieventos.models.Usuario;
import br.com.calendario.apieventos.repository.EventoRepository;
import br.com.calendario.apieventos.utils.JwtUtil;

@RestController
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping
	public ResponseEntity<?> inserir(@RequestBody Evento evento) {
		
		eventoRepository.save(evento);
		return ResponseEntity.ok("Inserido com sucesso!");
	}
	
	@GetMapping
	public ResponseEntity<?> inserir(HttpServletRequest request) {
		
		Usuario usuario = new Usuario();
		usuario.setId(jwtUtil.extractId(request.getHeader("Authorization").substring(7)));
		return ResponseEntity.ok(eventoRepository.findByUsuario(usuario));
	}
}
