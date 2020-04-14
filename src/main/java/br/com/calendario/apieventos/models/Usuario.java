package br.com.calendario.apieventos.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="usuario_id_seq")
	protected Integer id;
	
	@Column(unique = true, nullable = false)
	protected String login;
	
	@NotNull
	@JsonIgnore
	protected String senha;
	
	@OneToMany
	protected List<Evento> eventos;
	
	@OneToMany
	protected List<Convite> convites;
	

	public Usuario() {}

	public Usuario(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
