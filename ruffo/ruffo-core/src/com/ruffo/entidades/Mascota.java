package com.ruffo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Mascota
 *
 */
@Entity
public class Mascota implements Serializable {
	   
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	
	@OneToOne
	private SexoMascota sexo;
	
	@OneToOne
	private Raza raza;
	
	@OneToOne
	private Tamanio tamanio;
	
	@OneToOne
	private Color colorPredominante;
	
	@OneToOne
	private Color colorSecundario;
	
	private String nroChip;
	
	private String nroBeacon;
	
	@ManyToOne
	private Usuario propietario;	
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy="mascota")	
	private List<Imagen> imagenes;

	public Mascota() {
		super();
	}		

	public Mascota(Long id, String nombre, SexoMascota sexo, Raza raza, Tamanio tamanio, Color colorPredominante,
			Color colorSecundario, String nroChip, String nroBeacon, Usuario propietario, Date fechaNacimiento,
			List<Imagen> imagenes, List<CaracteristicaEspecial> caracteristicasEspeciales) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sexo = sexo;
		this.raza = raza;
		this.tamanio = tamanio;
		this.colorPredominante = colorPredominante;
		this.colorSecundario = colorSecundario;
		this.nroChip = nroChip;
		this.nroBeacon = nroBeacon;
		this.propietario = propietario;
		this.fechaNacimiento = fechaNacimiento;
		this.imagenes = imagenes;
	} 

	public Color getColorPredominante() {
		return colorPredominante;
	}

	public void setColorPredominante(Color colorPredominante) {
		this.colorPredominante = colorPredominante;
	}

	public Color getColorSecundario() {
		return colorSecundario;
	}

	public void setColorSecundario(Color colorSecundario) {
		this.colorSecundario = colorSecundario;
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

	public SexoMascota getSexo() {
		return sexo;
	}

	public void setSexo(SexoMascota sexo) {
		this.sexo = sexo;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public Tamanio getTamanio() {
		return tamanio;
	}

	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}

	public String getNroChip() {
		return nroChip;
	}

	public void setNroChip(String nroChip) {
		this.nroChip = nroChip;
	}

	public String getNroBeacon() {
		return nroBeacon;
	}

	public void setNroBeacon(String nroBeacon) {
		this.nroBeacon = nroBeacon;
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Imagen> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<Imagen> imagenes) {
		this.imagenes = imagenes;
	}
}
