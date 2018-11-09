package com.ruffo.dto;

import java.io.Serializable;

public class EnvioMailMascotaEncontradaDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public String destinatario;
	
	public String nombreMascota; 
	
	public String mailUsuarioQueEncuentra;
	
	public String telefonoDeContacto;

	public EnvioMailMascotaEncontradaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnvioMailMascotaEncontradaDto(String destinatario, String nombreMascota, String mailUsuarioQueEncuentra,
			String telefonoDeContacto) {
		super();
		this.destinatario = destinatario;
		this.nombreMascota = nombreMascota;
		this.mailUsuarioQueEncuentra = mailUsuarioQueEncuentra;
		this.telefonoDeContacto = telefonoDeContacto;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}


	public String getMailUsuarioQueEncuentra() {
		return mailUsuarioQueEncuentra;
	}

	public void setMailUsuarioQueEncuentra(String mailUsuarioQueEncuentra) {
		this.mailUsuarioQueEncuentra = mailUsuarioQueEncuentra;
	}

	public String getTelefonoDeContacto() {
		return telefonoDeContacto;
	}

	public void setTelefonoDeContacto(String telefonoDeContacto) {
		this.telefonoDeContacto = telefonoDeContacto;
	} 
	
	

}
