package com.ruffo.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Departamento
 *
 */
@Entity

public class Departamento implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descripcion;
	
	@OneToOne
	private Pais pais;
   
	public Departamento() {
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
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
   
}
