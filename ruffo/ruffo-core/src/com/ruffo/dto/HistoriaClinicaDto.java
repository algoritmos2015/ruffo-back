package com.ruffo.dto;

import java.util.List;

public class HistoriaClinicaDto {

	public Long id;
	
	public Long idMascota;
	
	public String nombreUsuario;
	
	public List<ConsultaClinicaDto> consultas;	

	public HistoriaClinicaDto() {
		super();
		// TODO Auto-generated constructor stub
	}	

	public HistoriaClinicaDto(Long id, Long idMascota, String nombreUsuario,
			List<ConsultaClinicaDto> consultas) {
		super();
		this.id = id;
		this.idMascota = idMascota;
		this.nombreUsuario = nombreUsuario;
		this.consultas = consultas;
	}

	public HistoriaClinicaDto(Long id, Long idMascota, List<ConsultaClinicaDto> consultas) {
		super();
		this.id = id;
		this.idMascota = idMascota;
		this.consultas = consultas;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Long idMascota) {
		this.idMascota = idMascota;
	}

	public List<ConsultaClinicaDto> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<ConsultaClinicaDto> consultas) {
		this.consultas = consultas;
	}		
}
