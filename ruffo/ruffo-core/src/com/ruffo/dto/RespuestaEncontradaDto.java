package com.ruffo.dto;

public class RespuestaEncontradaDto {
	
	public String nombre;
	
	public String mail;
	
	public String telefono;
	
	public String descripcion;

	public String imagenes;


	public RespuestaEncontradaDto(String nombre, String mail, String telefono, String descripcion) {
		super();
		this.nombre = nombre;
		this.mail = mail;
		this.telefono = telefono;
		this.descripcion = descripcion;
	}

	public String getImagenes() {
		return imagenes;
	}
	
	public void setImagenes(String imagenes) {
		this.imagenes = imagenes;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
