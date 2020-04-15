package br.com.calendario.apieventos.security;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.calendario.apieventos.models.Usuario;

public class UsuarioSecurity extends Usuario implements UserDetails, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public UsuarioSecurity() {}

	public UsuarioSecurity(int id, String login, String senha) {
		this();
		setId(id);
		setLogin(login);
		setSenha(senha);
	}
	
	private String newPassword;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}
	
	public void setnewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public String getNewPassword() {
		return this.newPassword;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
