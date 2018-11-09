package com.ruffo.dto;

public class RolDto {
	
	public String nombre;

	public RolDto() {
		super();
	}
	public RolDto(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
