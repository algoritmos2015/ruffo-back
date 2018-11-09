package com.ruffo.dto;

import java.util.List;

public class BusquedaBeaconParametroDto {
	
	public String nombreUsuario;
	
	public String nroChip;
	
	public List<String> nroBeacon;
	
	public BusquedaBeaconParametroDto() {
		super();
	}

	public BusquedaBeaconParametroDto(String nombreUsuario, List<String> nroBeacon) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.nroBeacon = nroBeacon;
	}

	public BusquedaBeaconParametroDto(String nombreUsuario, String nroChip) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.nroChip = nroChip;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public List<String> getNroBeacon() {
		return nroBeacon;
	}

	public void setNroBeacon(List<String> nroBeacon) {
		this.nroBeacon = nroBeacon;
	}

	public String getNroChip() {
		return nroChip;
	}

	public void setNroChip(String nroChip) {
		this.nroChip = nroChip;
	}
	
}
