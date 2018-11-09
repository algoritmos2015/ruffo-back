package com.ruffo.rest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.ruffo.dto.PersonaDto;
import com.ruffo.mensajes.MensajesValidacion;
import com.ruffo.servicios.implementaciones.PersonaServiceImp;
import com.ruffo.servicios.interfaces.PersonaService;
import com.ruffo.utils.Constantes;
import com.ruffo.utils.PrivilegiosChequeoException;
import com.ruffo.utils.SeguridadChequeoException;

@RequestScoped
@Path("persona")
public class PersonaRS {
	
	@EJB
	PersonaService personaService;
	
	static Logger log4j = Logger.getLogger(PersonaServiceImp.class);
	
	private Gson gson = new GsonBuilder().setDateFormat(Constantes.FORMATO_FECHA).create();
	
	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response agregarPersona(PersonaDto personaDTO) {		 
		try {
			return personaService.agregarPersona(personaDTO);
		} 
		catch (SeguridadChequeoException e2) {
			log4j.fatal(e2.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e2.getMessage()).build();
		}	
		catch (PrivilegiosChequeoException e3) {
			log4j.fatal(e3.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e3.getMessage()).build();
		}	
	}
	
	@PUT
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response modificarPersona(String mensajeJson) {
		PersonaDto personaDTO = new PersonaDto();				 
		try {
			personaDTO = gson.fromJson(mensajeJson, PersonaDto.class);
			return personaService.modificarPersona(personaDTO);
		} catch (JsonParseException e) {
			log4j.fatal(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.ERROR_AL_MODIFICAR_PERSONA).build();
		}		
		catch (SeguridadChequeoException e2) {
			log4j.fatal(e2.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e2.getMessage()).build();
		}	
		catch (PrivilegiosChequeoException e3) {
			log4j.fatal(e3.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e3.getMessage()).build();
		}
	}
	
	@DELETE
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response eliminarPersona(@QueryParam("id") String id) {			 
		try {
			return personaService.eliminarPersona(id);
		} catch (JsonParseException e) {
			log4j.fatal(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.ERROR_AL_ELIMINAR_PERSONA).build();
		}	
		catch (SeguridadChequeoException e2) {
			log4j.fatal(e2.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e2.getMessage()).build();
		}	
		catch (PrivilegiosChequeoException e3) {
			log4j.fatal(e3.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e3.getMessage()).build();
		}
	}
	
	@GET
	@Path("/todas")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerPersonas(@QueryParam("nroPagina") Integer nroPagina, @QueryParam("cantPorPagina") Integer cantPorPagina) {
		try {
			return personaService.obtenerPersonas(nroPagina, cantPorPagina);					
		}
		catch (SeguridadChequeoException e2) {
			log4j.fatal(e2.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e2.getMessage()).build();
		}	
		catch (PrivilegiosChequeoException e3) {
			log4j.fatal(e3.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e3.getMessage()).build();
		}
	}
	
	@GET
	@Path("/validar/mail")
	@Produces("application/json")
	@Consumes("application/json")
	public Response validarMail(@QueryParam("eMail") String eMail) {		 
		try {
			return personaService.validarMail(eMail);
		} 
		catch (SeguridadChequeoException e2) {
			log4j.fatal(e2.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e2.getMessage()).build();
		}	
		catch (PrivilegiosChequeoException e3) {
			log4j.fatal(e3.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e3.getMessage()).build();
		}	
	}
}