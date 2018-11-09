package com.ruffo.rest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.ruffo.dto.BusquedaBeaconParametroDto;
import com.ruffo.dto.CaracteristicaEspecialDto;
import com.ruffo.dto.MascotaPerdidaDto;
import com.ruffo.servicios.implementaciones.MascotaServiceImp;
import com.ruffo.servicios.interfaces.MascotaPerdidaService;
import com.ruffo.utils.PrivilegiosChequeoException;
import com.ruffo.utils.SeguridadChequeoException;

@RequestScoped
@Path("mascotaPerdida")
public class MascotaPerdidaRS {
	
	@EJB
	MascotaPerdidaService mascotaPerdidaService;
	
	static Logger log4j = Logger.getLogger(MascotaServiceImp.class);
	
	
	@POST
	@Path("/encontrada")
	@Produces("application/json")
	@Consumes("application/json")
	public Response agregarMascotaPerdidaEncontrada(MascotaPerdidaDto mascotaDto) {			 
		try {
			return mascotaPerdidaService.agregarMascotaAjenaEncontrada(mascotaDto);
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
	@Path("/caracteristica/especial")
	@Produces("application/json")
	@Consumes("application/json")
	public Response agregarCaracteristicaEspecial(CaracteristicaEspecialDto caracteristicaEspecialDto) {			 
		try {
			return mascotaPerdidaService.agregarCaracteristicaEspecial(caracteristicaEspecialDto);
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
	@Path("/caracteristica/especial")
	@Produces("application/json")
	@Consumes("application/json")
	public Response modificarCaracteristicaEspecial(CaracteristicaEspecialDto caracteristicaEspecialDto) {			 
		try {
			return mascotaPerdidaService.modificarCaracteristicaEspecial(caracteristicaEspecialDto);
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
	@Path("/buscar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response buscarMascotaPerdida(MascotaPerdidaDto mascotaPerdidaDto) {			 
		try {
			return mascotaPerdidaService.buscarMascotaPerdidaEnBPM(mascotaPerdidaDto);
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
	@Path("/buscar/propia")
	@Produces("application/json")
	@Consumes("application/json")
	public Response buscarMascotaPerdidaPropia(MascotaPerdidaDto mascotaPerdidaDto) {			 
		try {
			return mascotaPerdidaService.buscarMascotaPerdidaEnMascotasPerdidas(mascotaPerdidaDto);
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
	@Path("/pasar/estado/encontrado")
	@Produces("application/json")
	@Consumes("application/json")
	public Response pasarMascotaAEstadoEncontrado(@QueryParam("idMascotaPerdida") Long idMascotaPerdida, @QueryParam("idMascota") Long idMascota) {			 
		try {
			return mascotaPerdidaService.pasarMascotaAEstadoEncontrado(idMascotaPerdida, idMascota);
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
	@Path("/encontradas/usuario")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerMascotasEncontradasDeUsuario(@QueryParam("nombreUsuario") String nombreUsuario) {			 
		try {
			return mascotaPerdidaService.obtenerMascotasEncontradasDeUsuario(nombreUsuario);
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
	@Path("/lectura")
	@Produces("application/json")
	@Consumes("application/json")
	public Response realizarLecturaDeNroChipNroBeacon(BusquedaBeaconParametroDto busquedaBeaconParametroDto) {			 
		try {
			return mascotaPerdidaService.realizarLecturaDeNroChipNroBeacon(busquedaBeaconParametroDto);
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
	@Path("/desactivar/busqueda")
	@Produces("application/json")
	@Consumes("application/json")
	public Response desactivarBusquedaDeMascota(@QueryParam("idMascotaPerdida") Long idMascotaPerdida) {			 
		try {
			return mascotaPerdidaService.desactivarBusquedaDeMascota(idMascotaPerdida);
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
	@Path("/desactivar/busqueda")
	@Produces("application/json")
	@Consumes("application/json")
	public Response desactivarBusquedaDeMascotaPorObjeto(MascotaPerdidaDto mascotaPerdidaDto) {			 
		try {
			return mascotaPerdidaService.desactivarBusquedaDeMascotaPorObjeto(mascotaPerdidaDto);
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
