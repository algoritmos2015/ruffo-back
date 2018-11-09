package com.ruffo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MascotaPerdida implements Serializable {
	   
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	
	private String sexo;
	
	private String raza;
	
	private String tamanio;
	
	private String colorPredominante;
	
	private String colorSecundario;
	
	private String nroChip;
	
	private String nroBeacon;
	
	private String propietario;	
	
	public String pais;
	
	public String departamento;
	
	public String localidad;
	
	public Long latitud;
	
	public Long longitud;
	
	private String telefono;
	
	@ElementCollection(targetClass=String.class)
	@Column(length = 4000)
	private List<String> imagenes;
	
	@ElementCollection(targetClass=String.class)
	private List<String> caracteristicasEspeciales;
	
	private Boolean busquedaActiva;
	
	private String tipoMascota;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public String getColorPredominante() {
		return colorPredominante;
	}

	public void setColorPredominante(String colorPredominante) {
		this.colorPredominante = colorPredominante;
	}

	public String getColorSecundario() {
		return colorSecundario;
	}

	public void setColorSecundario(String colorSecundario) {
		this.colorSecundario = colorSecundario;
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

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public List<String> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<String> imagenes) {
		this.imagenes = imagenes;
	}

	public List<String> getCaracteristicasEspeciales() {
		return caracteristicasEspeciales;
	}

	public void setCaracteristicasEspeciales(List<String> caracteristicasEspeciales) {
		this.caracteristicasEspeciales = caracteristicasEspeciales;
	}
	
	public Boolean getBusquedaActiva() {
		return busquedaActiva;
	}

	public void setBusquedaActiva(Boolean busquedaActiva) {
		this.busquedaActiva = busquedaActiva;
	}

	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipoMascota() {
		return tipoMascota;
	}
	
	public void setTipoMascota(String tipoMascota) {
		this.tipoMascota = tipoMascota;
	}
	
	

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public MascotaPerdida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MascotaPerdida(Long id, String nombre, String sexo, String raza, String tamanio, String colorPredominante,
			String colorSecundario, String nroChip, String nroBeacon, String propietario, String pais,
			String departamento, String localidad, Long latitud, Long longitud, String telefono, List<String> imagenes,
			List<String> caracteristicasEspeciales, Boolean busquedaActiva, String tipoMascota, Date fecha) {
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
		this.pais = pais;
		this.departamento = departamento;
		this.localidad = localidad;
		this.latitud = latitud;
		this.longitud = longitud;
		this.telefono = telefono;
		this.imagenes = imagenes;
		this.caracteristicasEspeciales = caracteristicasEspeciales;
		this.busquedaActiva = busquedaActiva;
		this.tipoMascota = tipoMascota;
		this.fecha = fecha;
	}	
}
