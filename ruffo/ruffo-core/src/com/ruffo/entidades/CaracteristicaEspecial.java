package com.ruffo.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: CaracteristasEspeciales
 *
 */
@Entity
public class CaracteristicaEspecial implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	
	@OneToOne
	private ParteMascota parteMascota;
	
	public CaracteristicaEspecial() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ParteMascota getParteMascota() {
		return parteMascota;
	}

	public void setParteMascota(ParteMascota parteMascota) {
		this.parteMascota = parteMascota;
	}

	 
}
