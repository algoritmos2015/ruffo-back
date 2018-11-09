package com.ruffo.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class MascotaDto {
	
	public Long id;
	
	public String nombre;
	
	public String sexo;
	
	public String tipo;
	
	public String raza;
	
	public String tamanio;
	
	public String colorPredominante;
	
	public String colorSecundario;
	
	public String nroChip;
	
	public String nroBeacon;
	
	public String propietario;	
	
	
	@Temporal(TemporalType.TIMESTAMP)
    public Date fechaNacimiento;
	
	public Long totalRegistros;

	private List<String> imagenes;
	
	public String estado;	

	public MascotaDto() {
		super();
	}


	public MascotaDto(Long id, String nombre, String sexo, String tipo, String raza, String tamanio,
			String colorPredominante, String colorSecundario, String nroChip, String nroBeacon, String propietario,
			Date fechaNacimiento, Long totalRegistros, List<String> imagenes, String estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sexo = sexo;
		this.tipo = tipo;
		this.raza = raza;
		this.tamanio = tamanio;
		this.colorPredominante = colorPredominante;
		this.colorSecundario = colorSecundario;
		this.nroChip = nroChip;
		this.nroBeacon = nroBeacon;
		this.propietario = propietario;
		this.fechaNacimiento = fechaNacimiento;
		this.totalRegistros = totalRegistros;
		this.imagenes = imagenes;
		this.estado = estado;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Long getTotalRegistros() {
		return totalRegistros;
	}


	public void setTotalRegistros(Long totalRegistros) {
		this.totalRegistros = totalRegistros;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public List<String> getImagenes() {
		return imagenes;
	}



	public void setImagenes(List<String> imagenes) {
		this.imagenes = imagenes;
	}

}
