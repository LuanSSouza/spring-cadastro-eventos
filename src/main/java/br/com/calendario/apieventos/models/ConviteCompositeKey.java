package br.com.calendario.apieventos.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Embeddable
public class ConviteCompositeKey implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn
	@OnDelete( action = OnDeleteAction.CASCADE )
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn
	@OnDelete( action = OnDeleteAction.CASCADE )
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