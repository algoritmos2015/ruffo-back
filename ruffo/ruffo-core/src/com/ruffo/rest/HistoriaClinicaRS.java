package com.ruffo.rest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.ruffo.dto.ConsultaClinicaDto;
import com.ruffo.dto.HistoriaClinicaDto;
import com.ruffo.servicios.implementaciones.MascotaServiceImp;
import com.ruffo.servicios.interfaces.HistoriaClinicaService;
import com.ruffo.utils.PrivilegiosChequeoException;
import com.ruffo.utils.SeguridadChequeoException;

@RequestScoped
@Path("historiaclinica")
public class HistoriaClinicaRS {
	
	static Logger log4j = Logger.getLogger(MascotaServiceImp.class);
	
	@EJB
	HistoriaClinicaService historiaClinicaService;
	
	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response agregarHistoriaClinica(HistoriaClinicaDto historiaClinicaDto) {
		try {
			return historiaClinicaService.agregarHistoriaClinica(historiaClinicaDto);
		} catch (SeguridadChequeoException e2) {
			log4j.fatal(e2.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e2.getMessage()).build();
		}	
		catch (PrivilegiosChequeoException e3) {
			log4j.fatal(e3.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e3.getMessage()).build();
		}	
	}
	
	@POST
	@Path("/{idHistoria}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response agregarConsultaClinica(@PathParam("idHistoria") Long idHistoria, ConsultaClinicaDto consulta) {
		try {
			return historiaClinicaService.agregarConsultaClinica(idHistoria, consulta);
		} catch (SeguridadChequeoException e2) {
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
	public Response modificarConsultaClinica(HistoriaClinicaDto historiaClinicaDto) {
		try {
			return historiaClinicaService.modificarConsultaClinica(historiaClinicaDto);
		} catch (SeguridadChequeoException e2) {
			log4j.fatal(e2.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e2.getMessage()).build();
		}	
		catch (PrivilegiosChequeoException e3) {
			log4j.fatal(e3.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e3.getMessage()).build();
		}	
	}
	
	@GET
	@Path("/mascota/{idMascota}/consultas")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerConsultasClinicaDeMascota(@PathParam("idMascota") Long idMascota, @QueryParam("nroPagina") Integer nroPagina, @QueryParam("cantPorPagina") Integer cantPorPagina) {
		try {
			return historiaClinicaService.obtenerConsultasClinicaDeMascota(idMascota, nroPagina, cantPorPagina);
		} catch (SeguridadChequeoException e2) {
			log4j.fatal(e2.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e2.getMessage()).build();
		}	
		catch (PrivilegiosChequeoException e3) {
			log4j.fatal(e3.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e3.getMessage()).build();
		}	
	}
	
	@GET
	@Path("/mascota")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerHistoriaClinicaDeMascota(@QueryParam("idMascota") Long idMascota, @QueryParam("nroPagina") Integer nroPagina, @QueryParam("cantPorPagina") Integer cantPorPagina) {
		try {
			return historiaClinicaService.obtenerHistoriasClinicasDeMascota(idMascota, nroPagina, cantPorPagina);
		} catch (SeguridadChequeoException e2) {
			log4j.fatal(e2.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e2.getMessage()).build();
		}	
		catch (PrivilegiosChequeoException e3) {
			log4j.fatal(e3.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e3.getMessage()).build();
		}	
	}
	
	@GET
	@Path("/consulta")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerConsultaClinicaPorId(@QueryParam("idConsulta") Long idConsulta) {
		try {
			return historiaClinicaService.obtenerConsultaClinicaPorId(idConsulta);
		} catch (SeguridadChequeoException e2) {
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
	public Response eliminarConsultaClinicaPorId(@QueryParam("idConsultaClinica") Long idConsultaClinica, @QueryParam("nombreUsuario") String nombreUsuario) {
		try {
			return historiaClinicaService.eliminarConsultaClinicaPorId(idConsultaClinica, nombreUsuario);
		} catch (SeguridadChequeoException e2) {
			log4j.fatal(e2.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e2.getMessage()).build();
		}	
		catch (PrivilegiosChequeoException e3) {
			log4j.fatal(e3.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e3.getMessage()).build();
		}	
	}

}
