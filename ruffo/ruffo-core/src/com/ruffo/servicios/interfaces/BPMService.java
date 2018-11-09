package com.ruffo.servicios.interfaces;

import javax.ws.rs.core.Response;

import com.ruffo.dto.MascotaPerdidaDto;
import com.ruffo.utils.PrivilegiosChequeoException;
import com.ruffo.utils.SeguridadChequeoException;

public interface BPMService {

	Response obtenerBPMTodos(Integer nroPagina, Integer cantPorPagina) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response cambiarActividadDeMascota(MascotaPerdidaDto mascotaPerdidaDto) throws SeguridadChequeoException, PrivilegiosChequeoException;

}
