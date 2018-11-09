package com.ruffo.servicios.interfaces;

import javax.ws.rs.core.Response;

import com.ruffo.dto.MascotaDto;
import com.ruffo.dto.MascotaPerdidaDto;
import com.ruffo.utils.PrivilegiosChequeoException;
import com.ruffo.utils.SeguridadChequeoException;

public interface MascotaService {

	Response agregarMascota(MascotaDto mascotaDto) throws SeguridadChequeoException, PrivilegiosChequeoException;
	
	Response denunciarMascotaPerdida(MascotaPerdidaDto mascotaDto) throws SeguridadChequeoException, PrivilegiosChequeoException;
	
	Response obtenerMascotasPorEstado(Integer idEstado, Integer nroPagina, Integer cantPorPagina) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response modificarMascota(MascotaDto mascotaDto) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response eliminarMascota(Long id) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response obtenerMascotas(Integer numeroDePagina, Integer cantidadPorPagina) throws SeguridadChequeoException, PrivilegiosChequeoException;
	
	Response obtenerMascotaPorId(Long id) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response obtenerMascotaPorNombreUsuario(String nombreUsuario) throws SeguridadChequeoException, PrivilegiosChequeoException;
	
	Response validarSiMascotaPerdida(Long idMascota) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response obtenerMascotasPerdidasDeUsuario(String nombreUsuario) throws SeguridadChequeoException, PrivilegiosChequeoException;
}
