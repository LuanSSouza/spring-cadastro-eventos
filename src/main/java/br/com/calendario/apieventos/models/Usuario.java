package br.com.calendario.apieventos.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="usuarios_id_seq")
	protected int id;
	
	@Column(unique = true)
	protected String login;
	
	@JsonIgnore
	protected String senha;
	
	@OneToMany
	protected List<Evento> eventos;
	

	public Usuario() {}

	public Usuario(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
