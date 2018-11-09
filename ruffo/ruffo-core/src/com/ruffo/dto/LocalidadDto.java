package com.ruffo.dto;

public class LocalidadDto extends CodigueraDto{

	public Long departamentoId;

	public Long getDepartamentoId() {
		return departamentoId;
	}

	public void setDepartamentoId(Long departamentoId) {
		this.departamentoId = departamentoId;
	}

	public LocalidadDto(Long id, String descripcion, Long departamentoId) {
		super(id, descripcion);
		this.departamentoId = departamentoId;
	}

	public LocalidadDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalidadDto(Long id, String descripcion) {
		super(id, descripcion);
		// TODO Auto-generated constructor stub
	}
	
	
}
