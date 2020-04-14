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

import br.com.calendario.apieventos.models.Evento;
import br.com.calendario.apieventos.models.Usuario;
import br.com.calendario.apieventos.repository.EventoRepository;
import br.com.calendario.apieventos.utils.JwtUtil;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping
	public ResponseEntity<?> inserir(HttpServletRequest request, @RequestBody Evento evento) {
		Usuario usuario = new Usuario();
		usuario.setId(jwtUtil.extractId(request.getHeader("Authorization").substring(7)));
		evento.setUsuario(usuario);
		eventoRepository.save(evento);
		return ResponseEntity.ok("Inserido com sucesso!");
	}
	
	@GetMapping
	public ResponseEntity<?> listar(HttpServletRequest request) {
		
		Usuario usuario = new Usuario();
		usuario.setId(jwtUtil.extractId(request.getHeader("Authorization").substring(7)));
		return ResponseEntity.ok(eventoRepository.findByUsuario(usuario));
	}
	
	@GetMapping(value = "{codigo}")
	public ResponseEntity<?> getByCodigo(HttpServletRequest request, @PathVariable int codigo) {
		return ResponseEntity.ok(eventoRepository.findByCodigo(codigo));
	}

	
	@DeleteMapping(value = "{codigo}")
	public ResponseEntity<?> delete(@PathVariable int codigo) {
		
		eventoRepository.deleteByCodigo(codigo);
		return ResponseEntity.ok("Removido com sucesso!");
	}
}
