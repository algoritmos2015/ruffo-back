package com.ruffo.servicios.implementaciones;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;

import com.ruffo.dao.CaracteristaEspecialDao;
import com.ruffo.dao.ColorDao;
import com.ruffo.dao.DepartamentoDao;
import com.ruffo.dao.LocalidadDao;
import com.ruffo.dao.PaisDao;
import com.ruffo.dao.ParteMascotaDao;
import com.ruffo.dao.RazaDao;
import com.ruffo.dao.SexoMascotaDao;
import com.ruffo.dao.TipoMascotaDao;
import com.ruffo.dto.CaracteristicaEspecialDto;
import com.ruffo.dto.DepartamentoDto;
import com.ruffo.dto.LocalidadDto;
import com.ruffo.entidades.CaracteristicaEspecial;
import com.ruffo.entidades.Color;
import com.ruffo.entidades.Departamento;
import com.ruffo.entidades.Localidad;
import com.ruffo.entidades.Pais;
import com.ruffo.entidades.ParteMascota;
import com.ruffo.entidades.Raza;
import com.ruffo.entidades.SexoMascota;
import com.ruffo.entidades.TipoMascota;
import com.ruffo.mensajes.MensajesValidacion;
import com.ruffo.servicios.interfaces.CodigueraService;

@Stateless
public class CodigueraServiceImp implements CodigueraService {
	
	private static final String RAZA_OTRA = "Otra";

	@Inject
	ColorDao colorDao;
	
	@Inject
	TipoMascotaDao tipoMascotaDao;
	
	@Inject
	SexoMascotaDao sexoMascotaDao;
	
	@Inject
	RazaDao razaDao;
	
	@Inject
	CaracteristaEspecialDao caracteristaEspecialDao;
	
	@Inject
	ParteMascotaDao parteMascotaDao;	

	@Inject
	DepartamentoDao departamentoDao;
	
	@Inject
	PaisDao paisDao;
	
	@Inject
	LocalidadDao localidadDao;

	@Override
	public Response obtenerColorPorTipo(String tipoColor) {
		if (StringUtils.isNotBlank(tipoColor) && (tipoColor.equalsIgnoreCase("P") || tipoColor.equalsIgnoreCase("S"))) {
			List<Color> coloresPorTipo = colorDao.obtenerColorPorTipo(tipoColor);
			return Response.ok().status(Response.Status.ACCEPTED).entity(coloresPorTipo).build();
		}	
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.TIPO_COLOR_INCORRECTO).build();
	}

	@Override
	public Response obtenerTiposDeMascotas() {
		List<TipoMascota> tiposDeMascotas = tipoMascotaDao.obtenerTiposDeMascotas();
		return Response.ok().status(Response.Status.ACCEPTED).entity(tiposDeMascotas).build(); 
	}

	@Override
	public Response obtenerSexosDeMascotas() {
		List<SexoMascota> sexosDeMascotas = sexoMascotaDao.findAll(1, 10);
		if (sexosDeMascotas == null || sexosDeMascotas.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.ERROR_AL_OBTENER_SEXOS_DE_MASCOTSA).build();
		return Response.ok().status(Response.Status.ACCEPTED).entity(sexosDeMascotas).build(); 
	}

	@Override
	public Response obtenerRazasDeMascotas(String tipoMascota) {
		List<Raza> razasDeMascotas = razaDao.obtenerRazasPorTipoDeMascota(tipoMascota);
		if (razasDeMascotas == null || razasDeMascotas.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.ERROR_AL_OBTENER_RAZAS_DE_MASCOTSA).build();
		return Response.ok().status(Response.Status.ACCEPTED).entity(razasDeMascotas).build(); 
	}

	@Override
	public Response obtenerCaracteristicasEspecialesDeMascotas(Integer nroPagina, Integer cantPorPagina) {
		List<CaracteristicaEspecial> caracteristicas = caracteristaEspecialDao.findAll(nroPagina, cantPorPagina);
		if (caracteristicas == null || caracteristicas.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.ERROR_AL_OBTENER_CARACTERISTICAS_ESPECIALES_DE_MASCOTSA).build();
		List<CaracteristicaEspecialDto> caracteristicasDto = new ArrayList<>();
		CaracteristicaEspecialDto carateristicaDto = null;
		for (CaracteristicaEspecial caracteristaEspecial : caracteristicas) {
			carateristicaDto = new CaracteristicaEspecialDto();
			carateristicaDto.setNombre(caracteristaEspecial.getNombre());
			carateristicaDto.setParteMascota(caracteristaEspecial.getParteMascota().getDescripcion());
			caracteristicasDto.add(carateristicaDto);
		}
		return Response.ok().status(Response.Status.ACCEPTED).entity(caracteristicasDto).build();
	}

	@Override
	public Response obtenerCaracteristicasEspecialesDeMascotasPorParte(String parte) {
		if (StringUtils.isBlank(parte))
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_REQUERIDO, "la parte de la mascota")).build();
		List<ParteMascota> partesDeMascotas = parteMascotaDao.findByAttribute(parte, "descripcion");
		if (partesDeMascotas == null || partesDeMascotas.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.PARTE_DE_MASCOTA_INCORRECTA).build();
		List<CaracteristicaEspecial> obtenerCaracteristicasEspecialesDeMascotasPorParte = caracteristaEspecialDao.obtenerCaracteristicasEspecialesDeMascotasPorParte(parte);
		List<CaracteristicaEspecialDto> caracteristicasDto = new ArrayList<>();
		CaracteristicaEspecialDto carateristicaDto = null;
		for (CaracteristicaEspecial caracteristaEspecial : obtenerCaracteristicasEspecialesDeMascotasPorParte) {
			carateristicaDto = new CaracteristicaEspecialDto();
			carateristicaDto.setNombre(caracteristaEspecial.getNombre());
			carateristicaDto.setParteMascota(caracteristaEspecial.getParteMascota().getDescripcion());
			caracteristicasDto.add(carateristicaDto);
		}
		return Response.ok().status(Response.Status.ACCEPTED).entity(caracteristicasDto).build();
	}

	@Override
	public Response obtenerRazasDeMascotasAutocompletar(String tipoMascota, String texto) {
		if (StringUtils.isBlank(tipoMascota))
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_REQUERIDO, "El tipo de mascota")).build();
		List<Raza> razasDeMascotas = new ArrayList<>();
		if (StringUtils.isBlank(texto)) {
			razasDeMascotas = razaDao.obtenerRazasDeMascotasAutocompletar(tipoMascota, RAZA_OTRA); 
		}
		razasDeMascotas = razaDao.obtenerRazasDeMascotasAutocompletar(tipoMascota, texto);
		if (razasDeMascotas == null || razasDeMascotas.size() < 1) {
			razasDeMascotas = razaDao.obtenerRazasDeMascotasAutocompletar(tipoMascota, RAZA_OTRA);
		}
		return Response.ok().status(Response.Status.ACCEPTED).entity(razasDeMascotas).build(); 
	}

	@Override
	public Response obtenerDeparamentos() {
		List<Departamento> departamentos = departamentoDao.findAll(1, 100);
		List<DepartamentoDto> departamentosDto = new ArrayList<>();
		if (departamentos != null && departamentos.size() > 0) {
			DepartamentoDto departamentoDto = null;
			for (Departamento departamento : departamentos) {
				departamentoDto = new DepartamentoDto(departamento.getId(), departamento.getDescripcion(), departamento.getPais().getId());
				departamentosDto.add(departamentoDto);
			}			
		}
		return Response.ok().status(Response.Status.ACCEPTED).entity(departamentosDto).build(); 
	}

	@Override
	public Response obtenerDeparamentosPorPais(Long idPais, Integer nroPagina, Integer cantPorPagina) {
		Pais pais = paisDao.find(idPais);
		List<DepartamentoDto> departamentosDto = new ArrayList<>();
		if (pais != null) {
			List<Departamento> departamentos = departamentoDao.obtenerDeparamentosPorPais(idPais, nroPagina, cantPorPagina);
			if (departamentos != null && departamentos.size() > 0) {
				DepartamentoDto departamentoDto = null;
				for (Departamento departamento : departamentos) {
					departamentoDto = new DepartamentoDto(departamento.getId(), departamento.getDescripcion(), departamento.getPais().getId());
					departamentosDto.add(departamentoDto);
				}			
			}
			return Response.ok().status(Response.Status.ACCEPTED).entity(departamentosDto).build(); 
		}
		return Response.ok().status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.PAIS_INEXISTENTE).build();
	}

	@Override
	public Response obtenerLocalidadesDeDeparamentos(Long idDepartamento, Integer nroPagina, Integer cantPorPagina) {
		Departamento departamento = departamentoDao.find(idDepartamento);
		List<LocalidadDto> localidadesDto = new ArrayList<>();
		if (departamento != null) {
			List<Localidad> localidades = localidadDao.obtenerLocalidadesPorDepartamento(idDepartamento, nroPagina, cantPorPagina);
			if (localidades != null && localidades.size() > 0) {
				LocalidadDto localidadDto = null;
				for (Localidad localidad : localidades) {
					localidadDto = new LocalidadDto(localidad.getId(), localidad.getDescripcion(), localidad.getDepartamento().getId());
					localidadesDto.add(localidadDto);
				}			
				localidadesDto.sort(Comparator.comparing(LocalidadDto::getDescripcion));
			}
			return Response.ok().status(Response.Status.ACCEPTED).entity(localidadesDto).build(); 
		}
		return Response.ok().status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.DEPARTAMENTO_INEXISTENTE).build();
	}

}
