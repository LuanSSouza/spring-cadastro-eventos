package br.com.calendario.apieventos.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "convite")
public class Convite {
	@EmbeddedId
    private ConviteCompositeKey keys;
	
	@NotNull
	@ManyToOne
    private ConviteStatus status;

	public ConviteCompositeKey getKeys() {
		return keys;
	}

	public void setKeys(ConviteCompositeKey keys) {
		this.keys = keys;
	}

	public ConviteStatus getStatus() {
		return status;
	}

	public void setStatus(ConviteStatus status) {
		this.status = status;
	}
}