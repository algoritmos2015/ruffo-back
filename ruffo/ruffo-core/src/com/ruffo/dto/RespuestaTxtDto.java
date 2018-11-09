package com.ruffo.dto;

public class RespuestaTxtDto {

	public String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public RespuestaTxtDto(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
}
