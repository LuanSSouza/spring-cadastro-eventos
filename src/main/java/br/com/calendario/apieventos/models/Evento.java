package br.com.calendario.apieventos.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity(name = "evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="evento_codigo_seq")
	private Integer codigo;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private Date inicio;
	
	@NotNull
	private Date termino;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	protected List<Convite> convites;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
