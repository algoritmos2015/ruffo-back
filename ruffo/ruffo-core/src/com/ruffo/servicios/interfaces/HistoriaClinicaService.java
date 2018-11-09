package com.ruffo.servicios.interfaces;

import javax.ws.rs.core.Response;

import com.ruffo.dto.ConsultaClinicaDto;
import com.ruffo.dto.HistoriaClinicaDto;
import com.ruffo.utils.PrivilegiosChequeoException;
import com.ruffo.utils.SeguridadChequeoException;

public interface HistoriaClinicaService {

	Response agregarHistoriaClinica(HistoriaClinicaDto historiaClinicaDto) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response modificarConsultaClinica(HistoriaClinicaDto historiaClinicaDto) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response obtenerHistoriasClinicasDeMascota(Long idMascota, Integer nroPagina, Integer cantPorPagina) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response obtenerConsultaClinicaPorId(Long id) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response eliminarConsultaClinicaPorId(Long idConsultaClinica, String nombreUsuario) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response agregarConsultaClinica(Long idHistoria, ConsultaClinicaDto consulta) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response obtenerConsultasClinicaDeMascota(Long idMascota, Integer nroPagina, Integer cantPorPagina) throws SeguridadChequeoException, PrivilegiosChequeoException;

}
