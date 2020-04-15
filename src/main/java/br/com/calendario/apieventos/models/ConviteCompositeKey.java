package br.com.calendario.apieventos.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ConviteCompositeKey implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Evento evento;
	
	

	public ConviteCompositeKey() {}

	public ConviteCompositeKey(Usuario usuario, Evento evento) {
		this.usuario = usuario;
		this.evento = evento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
}