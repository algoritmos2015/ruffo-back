package com.ruffo.rest;

import java.io.UnsupportedEncodingException;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.ruffo.servicios.implementaciones.MascotaServiceImp;
import com.ruffo.servicios.interfaces.CodigueraService;
import com.ruffo.utils.FuncionesUtilitarias;

@RequestScoped
@Path("codiguera")
public class CodigueraRS {
	
	@EJB
	CodigueraService codigueraService;
	
	static Logger log4j = Logger.getLogger(MascotaServiceImp.class);
	
	@GET
	@Path("/color/tipo")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerColoresPorTipo(@QueryParam("tipoColor") String tipoColor) {
		return codigueraService.obtenerColorPorTipo(tipoColor);	
	}
	
	@GET
	@Path("/tipos/mascotas")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerTiposDeMascotas() {
		return codigueraService.obtenerTiposDeMascotas();	
	}
	
	@GET
	@Path("/razas/mascotas")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerRazasDeMascotas(@QueryParam("tipoMascota") String tipoMascota) {
		return codigueraService.obtenerRazasDeMascotas(tipoMascota);	
	}
	
	@GET
	@Path("/razas/mascotas/{tipoMascota}/autocompletar/{texto}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerRazasDeMascotasAutocompletar(@PathParam("tipoMascota") String tipoMascota, @PathParam("texto") String texto) {
		return codigueraService.obtenerRazasDeMascotasAutocompletar(tipoMascota, texto);	
	}
	
	@GET
	@Path("/sexos/mascota")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerSexosDeMascotas() {
		return codigueraService.obtenerSexosDeMascotas();	
	}
	
	@GET
	@Path("/caracteristicas/especiales/mascota")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerCaracteristicasEspecialesDeMascotas( @QueryParam("nroPagina") Integer nroPagina, @QueryParam("cantPorPagina") Integer cantPorPagina) {
		return codigueraService.obtenerCaracteristicasEspecialesDeMascotas(nroPagina, cantPorPagina);	
	}
	
	@GET
	@Path("/caracteristicas/especiales/mascota/parte")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerCaracteristicasEspecialesDeMascotasPorParte(@QueryParam("parte") String parte) {
		return codigueraService.obtenerCaracteristicasEspecialesDeMascotasPorParte(parte);	
	}
	
	@GET
	@Path("/departamentos/pais/{idPais}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerDeparamentos(@PathParam("idPais") Long idPais, @QueryParam("nroPagina") Integer nroPagina, @QueryParam("cantPorPagina") Integer cantPorPagina) {
		return codigueraService.obtenerDeparamentosPorPais(idPais, nroPagina, cantPorPagina);	
	}
	
	@GET
	@Path("/localidades/departamento/{idDepartamento}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response obtenerLocalidadesDeDeparamentos(@PathParam("idDepartamento") Long idDepartamento, @QueryParam("nroPagina") Integer nroPagina, @QueryParam("cantPorPagina") Integer cantPorPagina) {
		return codigueraService.obtenerLocalidadesDeDeparamentos(idDepartamento, nroPagina, cantPorPagina);	
	}
	
	//Funciones para contribuir con el test. Se deben eliminar
	@POST
	@Path("/desencriptar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response desencriptar(@QueryParam("valor") String valor) {
		String desencriptar = null;
		try {
			desencriptar = FuncionesUtilitarias.desencriptar(valor);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok().status(Response.Status.ACCEPTED).entity(desencriptar).build(); 	
	}
}
