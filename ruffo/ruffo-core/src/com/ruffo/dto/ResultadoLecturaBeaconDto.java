package com.ruffo.dto;

import java.util.List;

public class ResultadoLecturaBeaconDto {
	
	public List <RespuestaEncontradaDto> mascotasPerdidas;
	
	public List <MascotaPerdidaDto> mascotasNoPerdidas;
	
	public List <MascotaPerdidaDto> mascotasNoPerdidasNroChip;

	public ResultadoLecturaBeaconDto() {
		super();
	}

	public ResultadoLecturaBeaconDto(List<RespuestaEncontradaDto> mascotasPerdidas, List<MascotaPerdidaDto> mascotasNoPerdidas, List<MascotaPerdidaDto> mascotasNoPerdidasNroChip) {
		super();
		this.mascotasPerdidas = mascotasPerdidas;
		this.mascotasNoPerdidas = mascotasNoPerdidas;
		this.mascotasNoPerdidasNroChip = mascotasNoPerdidasNroChip;
	}

	
	public List<MascotaPerdidaDto> getMascotasNoPerdidasNroChip() {
		return mascotasNoPerdidasNroChip;
	}

	public void setMascotasNoPerdidasNroChip(List<MascotaPerdidaDto> mascotasNoPerdidasNroChip) {
		this.mascotasNoPerdidasNroChip = mascotasNoPerdidasNroChip;
	}

	public List<RespuestaEncontradaDto> getMascotasPerdidas() {
		return mascotasPerdidas;
	}

	public void setMascotasPerdidas(List<RespuestaEncontradaDto> mascotasPerdidas) {
		this.mascotasPerdidas = mascotasPerdidas;
	}

	public List<MascotaPerdidaDto> getMascotasNoPerdidas() {
		return mascotasNoPerdidas;
	}

	public void setMascotasNoPerdidas(List<MascotaPerdidaDto> mascotasNoPerdidas) {
		this.mascotasNoPerdidas = mascotasNoPerdidas;
	}

}
