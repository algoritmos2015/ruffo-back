package com.ruffo.dto;

import java.io.Serializable;

public class UsuarioLogueadoDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Long idUsuario;
	public String nombreUsuario;
	public String tipoUsuario;
	public String token;
		
	public UsuarioLogueadoDto() {
		super();
	}
	public UsuarioLogueadoDto(Long idUsuario, String nombreUsuario, String tipoUsuario, String token) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.tipoUsuario = tipoUsuario;
		this.token = token;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
