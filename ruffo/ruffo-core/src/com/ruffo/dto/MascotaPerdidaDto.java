package com.ruffo.dto;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class MascotaPerdidaDto {

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
	
	private List<String> caracteristicas;
	
	public String pais;
	
	public String departamento;
	
	public String localidad;
	
	public Long latitud;
	
	public Long longitud;
	
	private Integer hitsCaracteristicasEspeciales;
	
	private Integer hitsCaracterisMascota;
	
	private Integer ranking;
	
	public String telefono;
	
	public Long idMascota;
	
	public String estado;

	public MascotaPerdidaDto() {
		super();
	}	
	
	public MascotaPerdidaDto(Long id, String nombre, String sexo, String tipo, String raza, String tamanio,
			String colorPredominante, String colorSecundario, String nroChip, String nroBeacon, String propietario,
			Date fechaNacimiento, Long totalRegistros, List<String> imagenes, List<String> caracteristicas, String pais,
			String departamento, String localidad, Long latitud, Long longitud, Integer hitsCaracteristicasEspeciales,
			Integer hitsCaracterisMascota, Integer ranking, String telefono, Long idMascota) {
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
		this.caracteristicas = caracteristicas;
		this.pais = pais;
		this.departamento = departamento;
		this.localidad = localidad;
		this.latitud = latitud;
		this.longitud = longitud;
		this.hitsCaracteristicasEspeciales = hitsCaracteristicasEspeciales;
		this.hitsCaracterisMascota = hitsCaracterisMascota;
		this.ranking = ranking;
		this.telefono = telefono;
		this.idMascota = idMascota;
	}
	
	

	public MascotaPerdidaDto(Long id, String nombre, String sexo, String tipo, String raza, String tamanio,
			String colorPredominante, String colorSecundario, String nroChip, String nroBeacon, String propietario,
			Date fechaNacimiento, Long totalRegistros, List<String> imagenes, List<String> caracteristicas, String pais,
			String departamento, String localidad, Long latitud, Long longitud, Integer hitsCaracteristicasEspeciales,
			Integer hitsCaracterisMascota, Integer ranking, String telefono, Long idMascota, String estado) {
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
		this.caracteristicas = caracteristicas;
		this.pais = pais;
		this.departamento = departamento;
		this.localidad = localidad;
		this.latitud = latitud;
		this.longitud = longitud;
		this.hitsCaracteristicasEspeciales = hitsCaracteristicasEspeciales;
		this.hitsCaracterisMascota = hitsCaracterisMascota;
		this.ranking = ranking;
		this.telefono = telefono;
		this.idMascota = idMascota;
		this.estado = estado;
	}

	public Long getLatitud() {
		return latitud;
	}

	public void setLatitud(Long latitud) {
		this.latitud = latitud;
	}

	public Long getLongitud() {
		return longitud;
	}

	public void setLongitud(Long longitud) {
		this.longitud = longitud;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
	public List<String> getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(List<String> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public Integer getHitsCaracteristicasEspeciales() {
		return hitsCaracteristicasEspeciales;
	}

	public void setHitsCaracteristicasEspeciales(Integer hits) {
		this.hitsCaracteristicasEspeciales = hits;
	}

	public Integer getHitsCaracterisMascota() {
		return hitsCaracterisMascota;
	}

	public void setHitsCaracterisMascota(Integer hitsCaracterisMascota) {
		this.hitsCaracterisMascota = hitsCaracterisMascota;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}
	
	

	public String getPais() {
		return pais;
	}



	public void setPais(String pais) {
		this.pais = pais;
	}



	public String getDepartamento() {
		return departamento;
	}



	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}



	public String getLocalidad() {
		return localidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public Long getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Long idMascota) {
		this.idMascota = idMascota;
	}

	public int compareTo(ResultadoBusquedaMascotaDto sesion) {
		/* Ordena de mayor a menor por fecha de ultimo acceso **/
		return this.ranking < sesion.getHits() ? -1 : this.ranking > sesion.getHits() ? 1 : 0;
	}
	

	public static Comparator<MascotaPerdidaDto> HitsAscendenteComparator  = new Comparator<MascotaPerdidaDto>() {
	public int compare(MascotaPerdidaDto fruit1, MascotaPerdidaDto fruit2) {	
		Integer fruitName1 = fruit1.getRanking();
		Integer fruitName2 = fruit2.getRanking();		
		
		//ascending order
		return fruitName1.compareTo(fruitName2);	
		}
	
	};
	
	public static Comparator<MascotaPerdidaDto> HitsDescendenteComparator  = new Comparator<MascotaPerdidaDto>() {
	public int compare(MascotaPerdidaDto fruit1, MascotaPerdidaDto fruit2) {	
		Integer fruitName1 = fruit1.getRanking();
		Integer fruitName2 = fruit2.getRanking();		
		
		//descending order
		return fruitName2.compareTo(fruitName1);
		}	
	};
}
