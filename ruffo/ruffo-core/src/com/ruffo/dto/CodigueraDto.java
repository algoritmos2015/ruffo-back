package com.ruffo.dto;

public class CodigueraDto {

	public Long id;
	
	public String descripcion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public CodigueraDto(Long id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public CodigueraDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
