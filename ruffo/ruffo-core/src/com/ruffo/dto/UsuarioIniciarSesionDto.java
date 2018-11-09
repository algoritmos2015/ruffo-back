package com.ruffo.dto;

import java.io.Serializable;
import java.util.Set;

public class UsuarioIniciarSesionDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public String nombreUsuario;
	public String clave;
	public String token;
	public Set<String> roles;
	
	public UsuarioIniciarSesionDto() {
	}
	
	public UsuarioIniciarSesionDto(String nombreUsuario, String clave, String token, Set<String> roles) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.token = token;
		this.roles = roles;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}	
}
