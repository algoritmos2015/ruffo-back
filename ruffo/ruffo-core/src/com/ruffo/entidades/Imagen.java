package com.ruffo.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Imagen
 *
 */
@Entity
public class Imagen implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String etiqueta;
	
	@ManyToOne
	private Mascota mascota;
	
	@Lob
	private String imagen;

	public Imagen() {
		super();
	}   
	
	
	
	public Imagen(Long id, String etiqueta, Mascota mascota, String imagen) {
		super();
		this.id = id;
		this.etiqueta = etiqueta;
		this.mascota = mascota;
		this.imagen = imagen;
	}



	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getEtiqueta() {
		return this.etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}   
	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
   
}
