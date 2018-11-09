package com.ruffo.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: CaracteristicaEspecialTemporal
 *
 */
@Entity
public class CaracteristicaEspecialTemporal implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private CaracteristicaEspecial caracteristica;
	
	public CaracteristicaEspecialTemporal() {
		super();
	}   
	
	
	public CaracteristicaEspecialTemporal(Long id, CaracteristicaEspecial caracterista) {
		super();
		this.id = id;
		this.caracteristica = caracterista;
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public CaracteristicaEspecial getCaracterista() {
		return caracteristica;
	}
	public void setCaracterista(CaracteristicaEspecial caracterista) {
		this.caracteristica = caracterista;
	}
   
}
