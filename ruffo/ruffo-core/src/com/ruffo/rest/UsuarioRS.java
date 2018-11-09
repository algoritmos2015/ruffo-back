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
import com.ruffo.dto.UsuarioDto;
import com.ruffo.dto.UsuarioIniciarSesionDto;
import com.ruffo.mensajes.MensajesValidacion;
import com.ruffo.servicios.implementaciones.UsuarioServiceImp;
import com.ruffo.servicios.interfaces.UsuarioService;
import com.ruffo.utils.Constantes;
import com.ruffo.utils.PrivilegiosChequeoException;
import com.ruffo.utils.SeguridadChequeoException; 

@RequestScoped
@Path("usuario")
public class UsuarioRS {

	@EJB
	UsuarioService usuarioService;
	
	static Logger log4j = Logger.getLogger(UsuarioServiceImp.class);
	
	private Gson gson = new GsonBuilder().setDateFormat(Constantes.FORMATO_FECHA).create();
 
	
	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response agregarUsuario(String mensajeJson) {				 
		try {
			UsuarioDto usuarioDto = gson.fromJson(mensajeJson, UsuarioDto.class);
			return usuarioService.agregarUsuario(usuarioDto);
		} catch (JsonParseException e) {
			log4j.fatal(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.INFORMACION_ENVIADA_FORMATO_INCORRECTO).build();
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
	
	@POST
	@Path("/activar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response activarUsuario(@QueryParam("eMail") String eMail, @QueryParam("codigoConfirmacion") String codigoConfirmacion) {
		return usuarioService.activarUsuario(eMail, codigoConfirmacion);
	}
	
	@POST
	@Path("/reenviar/activacion")
	@Produces("application/json")
	@Consumes("application/json")
	public Response reenviarCodigoActivacionUsuario(@QueryParam("eMail") String eMail) {
		return usuarioService.reenviarCodigoActivacionUsuario(eMail);
	}
	
	@PUT
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response modificarUsuario(UsuarioDto usuarioDTO) {			 
		try {
			return usuarioService.modificarUsuario(usuarioDTO);
		} catch (JsonParseException e) {
			log4j.fatal(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.INFORMACION_ENVIADA_FORMATO_INCORRECTO).build();
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
	public Response eliminarUsuario(@QueryParam("nombreUsuario") String nombreUsuario) {			 
		try {
			return usuarioService.eliminarUsuario(nombreUsuario);
		} catch (JsonParseException e) {
			log4j.fatal(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.INFORMACION_ENVIADA_FORMATO_INCORRECTO).build();
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
	public Response obtenerUsuarios(@QueryParam("nroPagina") Integer nroPagina, @QueryParam("cantPorPagina") Integer cantPorPagina) {
		try {
			return usuarioService.obtenerUsuarios(nroPagina, cantPorPagina);	
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
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerUsuarioPorId(@QueryParam("id") Long id) {
		try {
			return usuarioService.obtenerUsuarioPorId(id);	
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
	@Path("/nombre/usuario")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerUsuarioPorNombre(@QueryParam("nombreUsuario") String nombreUsuario) {
		try {
			return usuarioService.obtenerUsuarioPorNombre(nombreUsuario);	
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
	@Path("/tipos/usuarios")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerTiposDeUsuario() throws SeguridadChequeoException, PrivilegiosChequeoException {
		return usuarioService.obtenertiposDeUsuario();
	}
	
	@POST
    @Path("/iniciar/sesion")
	@Produces("application/json")
    @Consumes("application/json")
    public Response iniciarSesion(UsuarioIniciarSesionDto usuarioIniciarSesion) {
        try {       
        	return usuarioService.iniciarSesion(usuarioIniciarSesion); 
        } catch (JsonParseException e) {
			log4j.fatal(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.ERROR_LOGIN).build();
		}	
    }
	
	@POST
    @Path("/cerrar/sesion")
    @Consumes("application/json")
    public Response cerrarSesion(@QueryParam("nombreUsuario") String nombreUsuario) {
        try {         	
        	return usuarioService.cerrarSesion(nombreUsuario); 
        } catch (JsonParseException e) {
			log4j.fatal(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.ERROR_LOGIN).build();
		}	
    }
	
	@POST
	@Path("/olvido/clave")
	@Produces("application/json")
	@Consumes("application/json")
	public Response olvidoDeClave(@QueryParam("nombreUsuario") String nombreUsuario) {
		return usuarioService.olvidoDeClave(nombreUsuario);	
	}
	
	@POST
	@Path("/modificar/clave")
	@Produces("application/json")
	@Consumes("application/json")
	public Response modificarClave(UsuarioIniciarSesionDto usuarioIniciarSesion) {
		return usuarioService.modificarClave(usuarioIniciarSesion);	
	}
}
