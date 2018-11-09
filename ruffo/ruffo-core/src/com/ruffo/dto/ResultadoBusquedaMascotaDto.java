package com.ruffo.dto;

import java.util.Comparator;

public class ResultadoBusquedaMascotaDto {
	
	private Long idMascota;
	
	private Integer hits;
	
	public Long getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Long idMascota) {
		this.idMascota = idMascota;
	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	public int compareTo(ResultadoBusquedaMascotaDto sesion) {
		 /* Ordena de mayor a menor por fecha de ultimo acceso **/
	        return this.hits < sesion.getHits() ? -1 : this.hits > sesion.getHits() ? 1 : 0;
	}
	
	public static Comparator<ResultadoBusquedaMascotaDto> HitsAscendenteComparator  = new Comparator<ResultadoBusquedaMascotaDto>() {

	public int compare(ResultadoBusquedaMascotaDto fruit1, ResultadoBusquedaMascotaDto fruit2) {
	
		Integer fruitName1 = fruit1.getHits();
		Integer fruitName2 = fruit2.getHits();		
		
		//ascending order
		return fruitName1.compareTo(fruitName2);		
		
		//descending order
		//return fruitName2.compareTo(fruitName1);
		}
	
	};

}
