package com.ruffo.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Color
 *
 */
@Entity

public class Color implements Serializable {

	   
	@Id
	private Long id;
	private String descripcion;
	private String tipoColor;
	private static final long serialVersionUID = 1L;

	public Color() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipoColor() {
		return tipoColor;
	}
	public void setTipoColor(String tipoColor) {
		this.tipoColor = tipoColor;
	}
   
}
