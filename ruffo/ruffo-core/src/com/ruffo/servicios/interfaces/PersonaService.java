package com.ruffo.servicios.interfaces;

import javax.ws.rs.core.Response;

import com.ruffo.dto.PersonaDto;
import com.ruffo.entidades.Persona;
import com.ruffo.utils.PrivilegiosChequeoException;
import com.ruffo.utils.SeguridadChequeoException;

public interface PersonaService {

	Response agregarPersona(PersonaDto personaDto) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response modificarPersona(PersonaDto personaDTO) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response eliminarPersona(String id) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response obtenerPersonas(Integer numeroDePagina, Integer cantidadPorPagina) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response obtenerPersonasPorMail(String eMail) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Boolean validarDatosPersona(PersonaDto personaDto) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Persona obtenerPorId(Long id) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response validarMail(String eMail) throws SeguridadChequeoException, PrivilegiosChequeoException;
}
