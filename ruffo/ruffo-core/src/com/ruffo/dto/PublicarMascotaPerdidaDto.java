package com.ruffo.dto;

import java.io.Serializable;
import java.util.List;

import com.ruffo.entidades.CaracteristicaEspecial;
import com.ruffo.entidades.CaracteristicaEspecialTemporal;
import com.ruffo.entidades.Localidad;
import com.ruffo.entidades.Mascota;

public class PublicarMascotaPerdidaDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String token;
	
	private Mascota mascota;
	
	private Localidad localidad;
	
	private List<CaracteristicaEspecial> caracteristicasEspeciales;

	private List<CaracteristicaEspecialTemporal> caracteristicasEspecialesTemporales;

	public PublicarMascotaPerdidaDto() {
		super();
	}

	public PublicarMascotaPerdidaDto(String token, Mascota mascota, Localidad localidad,
			List<CaracteristicaEspecial> caracteristicasEspeciales,
			List<CaracteristicaEspecialTemporal> caracteristicasEspecialesTemporales) {
		super();
		this.token = token;
		this.mascota = mascota;
		this.localidad = localidad;
		this.caracteristicasEspeciales = caracteristicasEspeciales;
		this.caracteristicasEspecialesTemporales = caracteristicasEspecialesTemporales;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public List<CaracteristicaEspecial> getCaracteristicasEspeciales() {
		return caracteristicasEspeciales;
	}

	public void setCaracteristicasEspeciales(List<CaracteristicaEspecial> caracteristicasEspeciales) {
		this.caracteristicasEspeciales = caracteristicasEspeciales;
	}

	public List<CaracteristicaEspecialTemporal> getCaracteristicasEspecialesTemporales() {
		return caracteristicasEspecialesTemporales;
	}

	public void setCaracteristicasEspecialesTemporales(List<CaracteristicaEspecialTemporal> caracteristicasEspecialesTemporales) {
		this.caracteristicasEspecialesTemporales = caracteristicasEspecialesTemporales;
	}
	
	
}
