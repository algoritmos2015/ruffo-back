package com.ruffo.dto;

public class CaracteristicaEspecialDto {

	public Long id;
	
	public String nombre;

	public String parteMascota;
	
	public CaracteristicaEspecialDto() {
		super();
	}
		
	

	public CaracteristicaEspecialDto(Long id, String nombre, String parteMascota) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.parteMascota = parteMascota;
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

	public void setNombre(String descripcion) {
		this.nombre = descripcion;
	}

	public String getParteMascota() {
		return parteMascota;
	}

	public void setParteMascota(String parteMascota) {
		this.parteMascota = parteMascota;
	}
	
	
}
