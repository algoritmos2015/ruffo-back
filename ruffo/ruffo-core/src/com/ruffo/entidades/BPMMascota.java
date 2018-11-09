package com.ruffo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: BPMMascota
 *
 */
@Entity

public class BPMMascota implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date fechaDesde;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date fechaHasta;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private ActividadMascota actividad;
	
	@OneToOne
	private Usuario usuario;
	
	private String descripcion;
	
	private Long latitud;
	
	private Long longitud;
	
	@OneToOne
	private Mascota mascota; 
	
	@OneToOne
	private MascotaPerdida mascotaPerdida;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<CaracteristicaEspecialTemporal> caracteristicasEspeciales;
	
	@OneToOne
	private Localidad localidad;

	public BPMMascota() {
	}   
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public ActividadMascota getActividad() {
		return actividad;
	}

	public void setActividad(ActividadMascota actividad) {
		this.actividad = actividad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getLatitud() {
		return latitud;
	}

	public void setLatitud(Long latitud) {
		this.latitud = latitud;
	}

	public Long getLongitud() {
		return longitud;
	}

	public void setLongitud(Long longitud) {
		this.longitud = longitud;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public MascotaPerdida getMascotaPerdida() {
		return mascotaPerdida;
	}

	public void setMascotaPerdida(MascotaPerdida mascotaPerdida) {
		this.mascotaPerdida = mascotaPerdida;
	}

	public List<CaracteristicaEspecialTemporal> getCaracteristicasEspeciales() {
		return caracteristicasEspeciales;
	}

	public void setCaracteristicasEspeciales(List<CaracteristicaEspecialTemporal> caracteristicasEspeciales) {
		this.caracteristicasEspeciales = caracteristicasEspeciales;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
}
