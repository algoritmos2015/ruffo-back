package com.ruffo.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Rol
 *
 */
@Entity
public class Rol implements Serializable {
	   
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;

	public Rol() {
		super();
	}   
	
	public Rol(Long id, String nombreRol) {
		super();
		this.id = id;
		this.nombre = nombreRol;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreRol() {
		return nombre;
	}
	public void setNombreRol(String nombreRol) {
		this.nombre = nombreRol;
	}   
}
