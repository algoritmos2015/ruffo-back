package com.ruffo.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: HistoriaClinica
 *
 */
@Entity

public class HistoriaClinica implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private Mascota mascota;
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "historia")
	private List<ConsultaClinica> consultas;
	
	public HistoriaClinica() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	public List<ConsultaClinica> getConsultas() {
		return consultas;
	}
	public void setConsultas(List<ConsultaClinica> consultas) {
		this.consultas = consultas;
	}
	
	
   
}
