package com.ruffo.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ConsultaClinicaDto {
	
	public Long id;	
	
	public Long idUsuario;
	
	public String tipoUsuario;
	
	public String motivoConsulta;
	
	public String diagnostico;
	
	public String tratamiento;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	public String fechaString;
	
	public String nombreVeterinario;
	



	public ConsultaClinicaDto(Long id, Long idUsuario, String tipoUsuario, String motivoConsulta, String diagnostico,
			String tratamiento, Date fecha, String fechaString, String nombreVeterinario) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.tipoUsuario = tipoUsuario;
		this.motivoConsulta = motivoConsulta;
		this.diagnostico = diagnostico;
		this.tratamiento = tratamiento;
		this.fecha = fecha;
		this.fechaString = fechaString;
		this.nombreVeterinario = nombreVeterinario;
	}

	public String getNombreVeterinario() {
		return nombreVeterinario;
	}

	public void setNombreVeterinario(String nombreVeterinario) {
		this.nombreVeterinario = nombreVeterinario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}
	public String getFechaString() {
		return fechaString;
	}
	
	
	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}
	
	
	public ConsultaClinicaDto() {
		super();
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
