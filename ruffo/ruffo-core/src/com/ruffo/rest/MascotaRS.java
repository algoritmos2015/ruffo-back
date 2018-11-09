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

import com.ruffo.dto.MascotaDto;
import com.ruffo.dto.MascotaPerdidaDto;
import com.ruffo.servicios.implementaciones.MascotaServiceImp;
import com.ruffo.servicios.interfaces.MascotaService;
import com.ruffo.utils.PrivilegiosChequeoException;
import com.ruffo.utils.SeguridadChequeoException;

@RequestScoped
@Path("mascota")
public class MascotaRS {
	
	@EJB
	MascotaService mascotaService;
	
	static Logger log4j = Logger.getLogger(MascotaServiceImp.class);
	
	
	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response agregarMascota(MascotaDto mascotaDto) {			 
		try {
			return mascotaService.agregarMascota(mascotaDto);
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
	public Response modificarMascota(MascotaDto mascotaDto) {
		try {
			return mascotaService.modificarMascota(mascotaDto);
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
	public Response eliminarMascota(@QueryParam("id") Long id) {			 
		try {
			return mascotaService.eliminarMascota(id);
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
	@Path("/noextraviada/{idMascota}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response eliminarMascotaNoPerdida(@PathParam("idMascota") Long idMascota) {	
		try {
			return mascotaService.validarSiMascotaPerdida(idMascota);
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
	@Path("/todas")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerMascotas(@QueryParam("nroPagina") Integer nroPagina, @QueryParam("cantPorPagina") Integer cantPorPagina) {
		try {
			return mascotaService.obtenerMascotas(nroPagina, cantPorPagina);
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
	@Path("/denunciar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response denunciarMascotaPerdida(MascotaPerdidaDto mascotaDto) {			 
		try {
			return mascotaService.denunciarMascotaPerdida(mascotaDto);
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
	@Path("/estado")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerMascotasPorEstado(@QueryParam("idEstado") Integer idEstado, @QueryParam("nroPagina") Integer nroPagina, @QueryParam("cantPorPagina") Integer cantPorPagina) {
		try {
			return mascotaService.obtenerMascotasPorEstado(idEstado, nroPagina, cantPorPagina);
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
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerMascotasPorId(@QueryParam("id") Long id) {
		try {
			return mascotaService.obtenerMascotaPorId(id);
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
	@Path("/usuario")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerMascotasPorNombreUsuario(@QueryParam("nombreUsuario") String nombreUsuario) {
		try {
			return mascotaService.obtenerMascotaPorNombreUsuario(nombreUsuario);
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
	@Path("/perdidas/usuario")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerMascotasEncontradasDeUsuario(@QueryParam("nombreUsuario") String nombreUsuario) {			 
		try {
			return mascotaService.obtenerMascotasPerdidasDeUsuario(nombreUsuario);
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
