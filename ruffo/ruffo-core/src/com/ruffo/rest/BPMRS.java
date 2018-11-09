package com.ruffo.rest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.ruffo.dto.MascotaPerdidaDto;
import com.ruffo.servicios.implementaciones.PersonaServiceImp;
import com.ruffo.servicios.interfaces.BPMService;
import com.ruffo.utils.PrivilegiosChequeoException;
import com.ruffo.utils.SeguridadChequeoException;

@RequestScoped
@Path("bpm")
public class BPMRS {	
		
	@EJB
	BPMService bpmService;
	
	static Logger log4j = Logger.getLogger(PersonaServiceImp.class);
		
	@GET
	@Path("/todas")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerBPMTodos(@QueryParam("nroPagina") Integer nroPagina, @QueryParam("cantPorPagina") Integer cantPorPagina) {
		try {
			return bpmService.obtenerBPMTodos(nroPagina, cantPorPagina);					
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
	@Path("/cambiar/actividad")
	@Produces("application/json")
	@Consumes("application/json")
	public Response cambiarActividadDeMascota(MascotaPerdidaDto mascotaPerdidaDto) {
		try {
			return bpmService.cambiarActividadDeMascota(mascotaPerdidaDto);					
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
