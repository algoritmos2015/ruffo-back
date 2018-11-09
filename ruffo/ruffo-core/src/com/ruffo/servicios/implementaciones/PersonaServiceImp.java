package com.ruffo.servicios.implementaciones;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;

import com.ruffo.dao.PersonaDao;
import com.ruffo.dto.PersonaDto;
import com.ruffo.entidades.Persona;
import com.ruffo.mensajes.MensajesValidacion;
import com.ruffo.servicios.interfaces.PersonaService;
import com.ruffo.utils.Constantes;
import com.ruffo.utils.FuncionesUtilitarias;
import com.ruffo.utils.PrivilegiosChequeoException;
import com.ruffo.utils.SeguridadChequeo;
import com.ruffo.utils.SeguridadChequeoException;
import com.ruffo.utils.Service;
import com.ruffo.validadores.AgregarUsuarioValidador;

@Stateless
//@Transactional para hacer transaccional el ejb, en caso de error se hace rollback
//@ApplicationException(rollback=true) Agrego una exepcion y lo antoto, luego de error la lanzo y hace el rollback automatico
public class PersonaServiceImp implements PersonaService {
	
	@Inject
	PersonaDao personaDao;

	@Override
	@Service(validatorClass = AgregarUsuarioValidador.class)
	public Response agregarPersona(PersonaDto personaDto) throws SeguridadChequeoException, PrivilegiosChequeoException {
		String eMail = personaDto.geteMail();
		if (StringUtils.isBlank(eMail) || !(FuncionesUtilitarias.esMailFormatoCorrecto(eMail))) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.MAIL_CON_FORMATO_INCORRECTO).build();
		}
		
		ModelMapper modelMapper = new ModelMapper();
		Persona persona = new Persona();
		persona = modelMapper.map(personaDto, Persona.class);
		List<Persona> personasConMail = personaDao.findByAttribute(eMail, "eMail");
		if (!existenPersonasConMail(personasConMail)) {
			if (!esNombreDePersonaIncorrecto(personaDto)) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.NOMBRE_APELLIDO_PERSONA_INCORRECTO).build();
			}
			if (personaDto.getRutaImagen() == null){
				persona.setRutaImagen("");
			}
			personaDao.persist(persona);
			personaDto.setId(persona.getId());
		}
		else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.NOMBRE_USUARIO_EXISTENTE).build();
		}
		return Response.status(Response.Status.CREATED).entity(personaDto).build();
	}

	@Override
	@SeguridadChequeo
	public Response modificarPersona(PersonaDto personaDTO) {
		List<Persona> personasConMail = personaDao.findByAttribute(personaDTO.geteMail(), "eMail");
		if (!personasConMail.isEmpty() && personasConMail.size() > 0) {
			ModelMapper modelMapper = new ModelMapper();
			Persona persona = new Persona();
			persona = modelMapper.map(personaDTO, Persona.class);
			persona.setId(personasConMail.get(0).getId());
			if (esPersonaConNombreVacio(personaDTO) || personaDTO.getNombre() == null || personaDTO.getNombre().length() > Constantes.TAMANIO_MAX_VARCHAR_MYSQL) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.NOMBRE_USUARIO_INCORRECTO).build();
			}
			if (personaDTO.getRutaImagen() == null){
				persona.setRutaImagen("");
			}
			personaDao.edit(persona);
			personaDTO.setId(persona.getId());
			
		}		
		else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_INEXISTENTE).build();
		}
		return Response.status(Response.Status.CREATED).entity(personaDTO).build();
	}

	@Override
	@SeguridadChequeo
	public Response eliminarPersona(String id) {
		try {
			Long idPersona = new Long(id);
			Persona persona = personaDao.find(idPersona.longValue());
			if (persona != null) {
				personaDao.remove(persona);			
			}		
			else {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_INEXISTENTE).build();
			}
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.OPERACION_EXITOSA).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.ERROR_ID_INVALIDO).build();
		}
	}

	@Override
	@SeguridadChequeo
	public Response obtenerPersonas(Integer numeroDePagina, Integer cantidadPorPagina) {
		List<Persona> personas = personaDao.findAll(numeroDePagina, cantidadPorPagina);
		List<PersonaDto> personasDTO = null;
		if (personas != null && !personas.isEmpty()) {
			personasDTO = new ArrayList<>();
			for (Persona p : personas) {
				ModelMapper modelMapper = new ModelMapper();
				PersonaDto pDTO = new PersonaDto();
				pDTO = modelMapper.map(p, PersonaDto.class);
				personasDTO.add(pDTO);
			}
			
		}
		return Response.status(Response.Status.CREATED).entity(personasDTO).build();
	}
	
	private boolean existenPersonasConMail(List<Persona> personasConNombre) {
		return !personasConNombre.isEmpty();
	}

	private boolean esPersonaConNombreVacio(PersonaDto PersonaDto) {
		return PersonaDto.getNombre().trim().equalsIgnoreCase("");
	}

	@Override
	public Response obtenerPersonasPorMail(String eMail) throws SeguridadChequeoException, PrivilegiosChequeoException {
		List<Persona> findByAttribute = personaDao.findByAttribute(eMail, "eMail");
		return Response.status(Response.Status.OK).entity(findByAttribute).build();
	}

	@Override
	@SeguridadChequeo
	public Boolean validarDatosPersona(PersonaDto personaDto) throws SeguridadChequeoException, PrivilegiosChequeoException {
		List<Persona> personasConMail = personaDao.findByAttribute(personaDto.geteMail(), "eMail");
		if (personasConMail != null && personasConMail.size() > 0) {
			return !esNombreDePersonaIncorrecto(personaDto);			
		}
		return false;
	}

	private Boolean esNombreDePersonaIncorrecto(PersonaDto personaDto) {
		return esPersonaConNombreVacio(personaDto) && personaDto.getNombre() == null && personaDto.getNombre().length() > Constantes.TAMANIO_MAX_VARCHAR_MYSQL;
	}

	@Override
	@SeguridadChequeo
	public Persona obtenerPorId(Long id) throws SeguridadChequeoException, PrivilegiosChequeoException {
		return personaDao.find(id);
	}

	@Override
	public Response validarMail(String eMail) throws SeguridadChequeoException, PrivilegiosChequeoException {
		//Validaciones del formato del mail
		if (StringUtils.isBlank(eMail) || !(FuncionesUtilitarias.esMailFormatoCorrecto(eMail))) 
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.MAIL_CON_FORMATO_INCORRECTO).build();
		List<Persona> findByAttribute = personaDao.findByAttribute(eMail, "eMail");
		if (findByAttribute != null || findByAttribute.size() > 0)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.MAIL_NO_DISPONIBLE).build();
		return Response.status(Response.Status.OK).entity(MensajesValidacion.MAIL_DISPONIBLE).build(); 
	}

}