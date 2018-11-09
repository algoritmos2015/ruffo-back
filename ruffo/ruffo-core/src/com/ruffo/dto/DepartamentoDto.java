package com.ruffo.dto;

public class DepartamentoDto extends CodigueraDto{

	public Long paisId;

	public Long getPaisId() {
		return paisId;
	}

	public void setPaisId(Long paisId) {
		this.paisId = paisId;
	}

	public DepartamentoDto(Long id, String descripcion, Long paisId) {
		super(id, descripcion);
		this.paisId = paisId;
	}

	public DepartamentoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartamentoDto(Long id, String descripcion) {
		super(id, descripcion);
		// TODO Auto-generated constructor stub
	}
}
