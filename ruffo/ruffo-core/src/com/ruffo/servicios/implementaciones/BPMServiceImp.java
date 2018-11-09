package com.ruffo.servicios.implementaciones;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import com.ruffo.dao.ActividadMascotaDao;
import com.ruffo.dao.BPMMascotaDao;
import com.ruffo.dto.MascotaPerdidaDto;
import com.ruffo.entidades.ActividadMascota;
import com.ruffo.entidades.BPMMascota;
import com.ruffo.mensajes.MensajesValidacion;
import com.ruffo.servicios.interfaces.BPMService;
import com.ruffo.utils.Constantes;
import com.ruffo.utils.PrivilegiosChequeoException;
import com.ruffo.utils.SeguridadChequeoException;

@Stateless
public class BPMServiceImp implements BPMService {

	@Inject
	BPMMascotaDao bpmMascotaDao;
	
	@Inject
	ActividadMascotaDao actividadMascotaDao;
	
	@Override
	public Response obtenerBPMTodos(Integer nroPagina, Integer cantPorPagina) throws SeguridadChequeoException, PrivilegiosChequeoException {
		List<BPMMascota> findAll = bpmMascotaDao.findAll(nroPagina, cantPorPagina);
		return Response.ok().status(Response.Status.OK).entity(findAll).build();
	}

	@Override
	public Response cambiarActividadDeMascota(MascotaPerdidaDto m) throws SeguridadChequeoException, PrivilegiosChequeoException {
		List<BPMMascota> mascotasPorIdMascota = bpmMascotaDao.obtenerMascotasDeBPM(m.getIdMascota());
		int cantidadDeMascota = 0;
		if (mascotasPorIdMascota != null && mascotasPorIdMascota.size() > 0) {
			for (BPMMascota bpmMascota : mascotasPorIdMascota) {
				if (bpmMascota.getFechaHasta() == null) {
					List<ActividadMascota> findByAttribute = actividadMascotaDao.findByAttribute(m.getEstado(), "descripcion");
					if (findByAttribute == null || findByAttribute.size() < 1) 
						return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.ACTIVIDAD_INCORRECTA).build();
					ActividadMascota actividadMascota = findByAttribute.get(0);
					bpmMascota.setFechaHasta(new Date());
					bpmMascotaDao.edit(bpmMascota);
					BPMMascota bpmMascotaNueva = new BPMMascota();
					bpmMascotaNueva.setActividad(actividadMascota);
					bpmMascotaNueva.setFechaDesde(new Date());
					bpmMascotaNueva.setFechaHasta(new Date());
					bpmMascotaNueva.setDescripcion(Constantes.ACT_AUTOMATICA_ENCONTRADA_OTRO_MEDIO);
					bpmMascotaNueva.setMascota(bpmMascota.getMascota());
					bpmMascotaNueva.setUsuario(bpmMascota.getUsuario());
					bpmMascotaDao.persist(bpmMascotaNueva);
					cantidadDeMascota ++;
				}
			}
		}
		if (cantidadDeMascota > 0)
			return Response.ok().status(Response.Status.OK).entity(MensajesValidacion.OPERACION_EXITOSA).build();
		return Response.ok().status(Response.Status.OK).entity(MensajesValidacion.MASCOTA_NO_EXTRAVIADA).build();
	}

}
