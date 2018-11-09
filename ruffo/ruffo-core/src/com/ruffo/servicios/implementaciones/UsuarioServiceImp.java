package com.ruffo.servicios.implementaciones;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;

import com.ruffo.dao.BPMMascotaDao;
import com.ruffo.dao.ConsultaClinicaDao;
import com.ruffo.dao.HistoriaClinicaDao;
import com.ruffo.dao.MascotaDao;
import com.ruffo.dao.MascotaPerdidaDao;
import com.ruffo.dao.PaisDao;
import com.ruffo.dao.RolDao;
import com.ruffo.dao.SesionDao;
import com.ruffo.dao.SexoDao;
import com.ruffo.dao.TipoUsuarioDao;
import com.ruffo.dao.UsuarioDao;
import com.ruffo.dto.MascotaDto;
import com.ruffo.dto.RolDto;
import com.ruffo.dto.UsuarioDto;
import com.ruffo.dto.UsuarioIniciarSesionDto;
import com.ruffo.dto.UsuarioLogueadoDto;
import com.ruffo.entidades.BPMMascota;
import com.ruffo.entidades.Color;
import com.ruffo.entidades.ConsultaClinica;
import com.ruffo.entidades.HistoriaClinica;
import com.ruffo.entidades.Imagen;
import com.ruffo.entidades.Mascota;
import com.ruffo.entidades.MascotaPerdida;
import com.ruffo.entidades.Pais;
import com.ruffo.entidades.Raza;
import com.ruffo.entidades.Rol;
import com.ruffo.entidades.Sesion;
import com.ruffo.entidades.Sexo;
import com.ruffo.entidades.SexoMascota;
import com.ruffo.entidades.Tamanio;
import com.ruffo.entidades.TipoMascota;
import com.ruffo.entidades.TipoUsuario;
import com.ruffo.entidades.Usuario;
import com.ruffo.mensajes.MensajesValidacion;
import com.ruffo.servicios.interfaces.UsuarioService;
import com.ruffo.utils.Constantes;
import com.ruffo.utils.EncolaMensaje;
import com.ruffo.utils.FuncionesUtilitarias;
import com.ruffo.utils.PrivilegiosChequeoException;
import com.ruffo.utils.RuffoConfig;
import com.ruffo.utils.SeguridadChequeo;
import com.ruffo.utils.SeguridadChequeoException;
import com.ruffo.utils.Service;
import com.ruffo.validadores.EliminarUsuarioValidador;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Stateless
public class UsuarioServiceImp implements UsuarioService{

	@Inject
	UsuarioDao usuarioDao;	

	@Inject
    HttpServletRequest request;

	
	@Inject
	PaisDao paisDao;
	
	@Inject
	SesionDao sesionDao;
	
	@Inject
	RolDao rolDao;
	
	@Inject
	TipoUsuarioDao tipoUsuarioDao;
	
	@Inject
	SexoDao sexoDao;
	
	@Inject
	BPMMascotaDao bpmMascotaDao;
	
	@Inject
	MascotaDao mascotaDao;
	
	@Inject
	MascotaPerdidaDao mascotaPerdidaDao;
	
	@Inject
	HistoriaClinicaDao historiaClinicaDao;
	
	@Inject
	ConsultaClinicaDao consultaClinicaDao;
	
	@Inject
	EncolaMensaje encolardorMensajes;
	
	static Logger log4j = Logger.getLogger(UsuarioServiceImp.class);
	
	@Override
	//@Service(validatorClass = AgregarUsuarioValidador.class)
	public Response agregarUsuario(UsuarioDto usuarioDto) throws SeguridadChequeoException, PrivilegiosChequeoException {
		StringBuilder sb = null;
		//Validaciones del mail
		String eMail = usuarioDto.geteMail();
		if (StringUtils.isBlank(eMail) || !(FuncionesUtilitarias.esMailFormatoCorrecto(eMail))) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.MAIL_CON_FORMATO_INCORRECTO).build();
		}
		
		List<Usuario> usuariosConMail = usuarioDao.findByAttribute(eMail, "eMail");		
		if (usuariosConMail != null && usuariosConMail.size() > 0) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_CON_MAIL_EXISTENTE).build();
		}
		
		//Validación de extensión y formato de clave
		String clave = usuarioDto.getClave();
		String claveEncriptada = null;
		if (FuncionesUtilitarias.esClaveFormatoCorrecto(clave))
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.FORMATO_CLAVE_INCORRECTO).build();
		else {
			try {
				claveEncriptada = FuncionesUtilitarias.encriptar(clave);
			} catch (UnsupportedEncodingException e) {
				log4j.fatal(e.getMessage());
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.FORMATO_CLAVE_INCORRECTO).build();
			}
		}
		//Validacion de la CI en caso de que se envíe
		String ci = usuarioDto.getCi();
		if (StringUtils.isNotBlank(ci)) {
			List<Usuario> usuariosPorCedula = usuarioDao.findByAttribute(ci, "ci");
			if (usuariosPorCedula != null && usuariosPorCedula.size() > 0) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_CON_CI_EXISTENTE).build();
			}			
		}
		
		//Validación de fecha de nacimiento. Debe ser mayor a 14 años
		Date addYears = DateUtils.addYears(usuarioDto.getFechaNacimiento(), 14);
		if (addYears.after(new Date())) 
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.FECHA_NACIMIENTO_INCORRECTA).build();
		
		//Validación de país existente
		String nombrePais = usuarioDto.getPais();
		List<Pais> paisesPorNombre = paisDao.findByAttribute(nombrePais, "nombre");
		if (paisesPorNombre == null || paisesPorNombre.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.PAIS_INEXISTENTE).build();
		Pais pais = paisesPorNombre.get(0);
		//TODO Se deben validar que los roles que se envían existen en la BD.
		
		//Validación de tipo de usuario ingresado en la bd
		String nombreUsuario = eMail;
		if (esFormatoDeNombreCorrectoEnMySQL(nombreUsuario)) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.NOMBRE_USUARIO_INCORRECTO).build();
		}
		else {
			usuarioDto.setNombreUsuario(nombreUsuario);
		}
		
		//Validación del tipo de usuario
		String nombreTipoUsuario = usuarioDto.getTipoUsuario();
		TipoUsuario tipoUsuario = null;
		List<TipoUsuario> tiposDeusuarios = tipoUsuarioDao.findByAttribute(nombreTipoUsuario, "descripcion");
		if (tiposDeusuarios == null || tiposDeusuarios.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.TIPO_USUARIO_INCORRECTO).build();
		else {
			tipoUsuario = new TipoUsuario();
			tipoUsuario = tiposDeusuarios.get(0);
		}
		
		//Validación del sexo	
		String sexoDescripcion = usuarioDto.getSexo().trim();
		List<Sexo> sexosPorDescripcion = sexoDao.findByAttribute(sexoDescripcion, "descripcion");
		if (sexosPorDescripcion == null || sexosPorDescripcion.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.SEXO_INCORRECTO).build();
		Sexo sexo = sexosPorDescripcion.get(0);
		
		
		String codigoConfirmacion = FuncionesUtilitarias.crearCodigoActivacion();
		String codigoConfirmacionEncriptado = null;
		try {
			codigoConfirmacionEncriptado = FuncionesUtilitarias.encriptar(codigoConfirmacion);
		} catch (UnsupportedEncodingException e) {
			sb = new StringBuilder("ERROR AL DESENCRIPTAR CODIGO DE CONFIRMACION! Usuario:");
			sb.append(nombreUsuario);
			sb.append(" EXEPCION:");
			sb.append(e.getMessage());
			log4j.fatal(sb.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.FORMATO_CLAVE_INCORRECTO).build();
		}
		Integer cantidadLogeosPermitidos = RuffoConfig.getConfiguration().getInt(RuffoConfig.CANTIDAD_LOGEOS_PERMITIDOS != null ? RuffoConfig.CANTIDAD_LOGEOS_PERMITIDOS : "10");
		ModelMapper modelMapper = new ModelMapper();
		Usuario usuario = new Usuario();
		usuario = modelMapper.map(usuarioDto, Usuario.class);
		usuario.setTipoUsuario(tipoUsuario);
		usuario.setCantLogeosPermitidos(cantidadLogeosPermitidos);
		usuario.setCantLogeosFallidos(0);
		//TODO Se guardan momentanemente los roles en null por alcance de proyecto
		usuario.setRoles(null);
		usuario.setActivo(false);
		usuario.setCodigoActivacion(codigoConfirmacionEncriptado);
		usuario.setPais(pais);
		usuario.setSexo(sexo);
		usuario.setClave(claveEncriptada);
		usuario.setActualizarClave(false);
		usuario.setTelefono(StringUtils.isNotBlank(usuarioDto.getTelefono()) ? usuarioDto.getTelefono() : null);
		usuario.setCelular(StringUtils.isNotBlank(usuarioDto.getCelular()) ? usuarioDto.getCelular() : null);
		usuarioDao.persist(usuario);
		
		usuarioDto.setId(usuario.getId());
		//Se oculta valor de clave
		usuarioDto.setClave(null);
		
		enviarMailConfirmacionDeCuenta(eMail, codigoConfirmacion);
		return Response.status(Response.Status.CREATED).entity(usuarioDto).build();
	}

	private boolean esFormatoDeNombreCorrectoEnMySQL(String nombre) {
		return nombre.length() > Constantes.TAMANIO_MAX_VARCHAR_MYSQL;
	}

	@Override
	//@Service(validatorClass = ModificarUsuarioValidador.class)
	public Response modificarUsuario(UsuarioDto usuarioDto) throws SeguridadChequeoException, PrivilegiosChequeoException{
		
		Usuario usuario = null;
		String nombreUsuario = usuarioDto.getNombreUsuario();
		if (StringUtils.isBlank(nombreUsuario))
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_REQUERIDO, "el nombre de usuario")).build();		
			
		List<Usuario> usuariosConMail = usuarioDao.findByAttribute(nombreUsuario, "nombreUsuario");
		if (usuariosConMail != null && usuariosConMail.size() > 0) {
			usuario = usuariosConMail.get(0);
			String nombrePersona = usuarioDto.getNombre();
			if (StringUtils.isNotBlank(nombrePersona)) {
				if (esFormatoDeNombreCorrectoEnMySQL(nombrePersona))
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.NOMBRE_APELLIDO_PERSONA_INCORRECTO).build();
				usuario.setNombre(usuarioDto.getNombre());				
			}
			
			String apellidoPersona = usuarioDto.getApellido();
			if (StringUtils.isNotBlank(apellidoPersona)) {
				if (esFormatoDeNombreCorrectoEnMySQL(nombrePersona))
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.NOMBRE_APELLIDO_PERSONA_INCORRECTO).build();	
				usuario.setApellido(usuarioDto.getApellido());				
			}
			
			String nombrePais = usuarioDto.getPais();
			if (StringUtils.isNotBlank(nombrePais)) {
				List<Pais> paisesPorNombre = paisDao.findByAttribute(nombrePais, "nombre");
				if (paisesPorNombre == null || paisesPorNombre.size() < 1)
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.PAIS_INEXISTENTE).build();				
				usuario.setPais(paisesPorNombre.get(0));
			}
			
			
			String nombreTipoUsuario = usuarioDto.getTipoUsuario();
			if (StringUtils.isNotBlank(nombreTipoUsuario)) {
				TipoUsuario tipoUsuario = null;
				List<TipoUsuario> tiposDeusuarios = tipoUsuarioDao.findByAttribute(nombreTipoUsuario, "descripcion");
				if (tiposDeusuarios == null || tiposDeusuarios.size() < 1)
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.TIPO_USUARIO_INCORRECTO).build();
				else {
					tipoUsuario = tiposDeusuarios.get(0);
					usuario.setTipoUsuario(tipoUsuario);
				}				
			}
			
			String ci = usuarioDto.getCi();
			if (StringUtils.isNotBlank(ci)) {
				List<Usuario> usuariosPorCi = usuarioDao.findByAttribute(ci, "ci");
				if (usuariosPorCi != null && usuariosPorCi.size() > 0)
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_CON_CI_EXISTENTE).build();	
				usuario.setCi(ci);;				
			}
			
			String celular = usuarioDto.getCelular();
			if (StringUtils.isNotBlank(celular))
				usuario.setCi(celular);
			
			String telefono = usuarioDto.getTelefono();
			if (StringUtils.isNotBlank(telefono))
				usuario.setTelefono(telefono);
			
			String imagen = usuarioDto.getImagen();
			if (StringUtils.isNotBlank(imagen))
				usuario.setImagen(imagen);
			
			usuarioDto.setClave(null);
			usuarioDao.edit(usuario);			
			
		}
		else 
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.USUARIO_INEXISTENTE)).build();
		return Response.status(Response.Status.CREATED).entity(usuarioDto).build();		
	}

	@Override
	@Service(validatorClass = EliminarUsuarioValidador.class)
	public Response eliminarUsuario(String nombreUsuario) throws SeguridadChequeoException, PrivilegiosChequeoException{
		if(StringUtils.isBlank(nombreUsuario))
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_REQUERIDO, "nombre de usuario")).build();
		
		List<Usuario> usuarios = usuarioDao.findByAttribute(nombreUsuario, "nombreUsuario");
		if (usuarios == null || usuarios.size() < 1) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_INEXISTENTE).build();
		}
		
		Usuario usuario = usuarios.get(0);
		if (usuario == null) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_INEXISTENTE).build();
		}		
		
		Long idUsuario = usuario.getId();
		if(idUsuario == null || idUsuario < 1) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.ID_USUARIO_INCORRECTO).build();
		}
		
		
		List<Mascota> mascotasDeUsuario = mascotaDao.obtenerMascotasPorIdUsuario(idUsuario);
		//Se eliminan las consultas clínicas de las mascotas del usuario
		List<ConsultaClinica> obtenerConsultaClinicaDeMascota = null;		
		obtenerConsultaClinicaDeMascota = consultaClinicaDao.obtenerConsultasClinicasRealizadasPorElUsuario(idUsuario);
		if (obtenerConsultaClinicaDeMascota != null && obtenerConsultaClinicaDeMascota.size() > 0) {
			for (ConsultaClinica historiaClinica : obtenerConsultaClinicaDeMascota) {
				consultaClinicaDao.remove(historiaClinica);
			}			
		}
				
		//Se eliminan las historias clínicas de las mascotas del usuario
		List<HistoriaClinica> obtenerHistoriaClinicaDeMascota = null;
		if (mascotasDeUsuario != null && mascotasDeUsuario.size() > 0) {
			for (Mascota mascota : mascotasDeUsuario) {
				obtenerHistoriaClinicaDeMascota = historiaClinicaDao.obtenerHistoriaClinicaDeMascota(mascota.getId());
				for (HistoriaClinica historiaClinica : obtenerHistoriaClinicaDeMascota)
					historiaClinicaDao.remove(historiaClinica);
			}			
		}
		
		//Se marcan como eliminadas del BPM pero se deja registro para informacion historica
		for (Mascota mascota : mascotasDeUsuario) {
			List <BPMMascota> mascotasEnBPM = bpmMascotaDao.obtenerMascotasDeBPM(mascota.getId());
			if (mascotasEnBPM.size() > 0) {
				for (BPMMascota bpmMascota : mascotasEnBPM) {
					if (bpmMascota.getFechaHasta() == null)
						bpmMascotaDao.remove(bpmMascota);
					else {
						bpmMascota.setDescripcion(String.format(Constantes.MASCOTA_ELIMINADA_DEL_SISTEMA, bpmMascota.getMascota().getId()) );
						bpmMascota.setMascota(null);
						bpmMascota.setUsuario(null);
						bpmMascota.setFechaHasta(new Date());
						bpmMascotaDao.edit(bpmMascota);
					}
				}
			}			
		}
		
		//Se eliminan las mascotas encontradas por el usuario
		List<MascotaPerdida> mascotasEncontradas = mascotaPerdidaDao.findByAttribute(nombreUsuario, "propietario");
		if (mascotasEncontradas != null && mascotasEncontradas.size() > 0) {
			for (MascotaPerdida mascotaPerdida : mascotasEncontradas) {
				if (mascotaPerdida.getPropietario().equalsIgnoreCase(nombreUsuario)) {				
					List <BPMMascota> mascotasPerdidasEnBPM = bpmMascotaDao.obtenerMascotasPerdidasDeBPM(mascotaPerdida.getId());
					if (mascotasPerdidasEnBPM.size() > 0) {
						for (BPMMascota bpmMascota : mascotasPerdidasEnBPM) {
							if (bpmMascota.getFechaHasta() == null)
								bpmMascotaDao.remove(bpmMascota);
							else {
								bpmMascota.setDescripcion(String.format(Constantes.MASCOTA_PERDIDA_ELIMINADA_DEL_SISTEMA, bpmMascota.getMascotaPerdida().getId()) );
								bpmMascota.setMascotaPerdida(null);
								bpmMascota.setUsuario(null);
								bpmMascota.setFechaHasta(new Date());
								bpmMascotaDao.edit(bpmMascota);
							}
						}
					}					
					mascotaPerdidaDao.remove(mascotaPerdida);
				}
			}			
		}
		
		//Se eliminan las sesiones que tuvo el usuario
		
		List<Sesion> sesionesIncativasDeUsuario = sesionDao.obtenerSesionesDeUsuario(idUsuario, false);
		if (sesionesIncativasDeUsuario != null && sesionesIncativasDeUsuario.size() > 0) {
			for (Sesion sesion : sesionesIncativasDeUsuario) {
				sesionDao.remove(sesion);
			}			
		}
		
		List<Sesion> sesionesActivasDeUsuario = sesionDao.obtenerSesionesDeUsuario(idUsuario, true);
		if (sesionesActivasDeUsuario != null && sesionesActivasDeUsuario.size() > 0) {
			for (Sesion sesion : sesionesActivasDeUsuario) {
				sesionDao.remove(sesion);
			}
		}	
		
		//Por último se eliina el usuario
		usuarioDao.remove(usuario);			
		return Response.status(Response.Status.OK).entity(MensajesValidacion.OPERACION_EXITOSA).build();
	}

	@Override
	@SeguridadChequeo
	public Response obtenerUsuarios(Integer nroPagina, Integer cantPorPagina) throws SeguridadChequeoException, PrivilegiosChequeoException{
		List<Usuario> usuarios = usuarioDao.findAll(nroPagina, cantPorPagina);
		List<UsuarioDto> usuariosDTO = null;
		if (usuarios != null && usuarios.size() > 0) {
			usuariosDTO = new ArrayList<>();
			for (Usuario usuario : usuarios) {
				ModelMapper modelMapper = new ModelMapper();
				UsuarioDto usuarioDTO = new UsuarioDto();
				usuarioDTO = modelMapper.map(usuario, UsuarioDto.class);
				usuariosDTO.add(usuarioDTO);
			}			
		}
		return Response.status(Response.Status.CREATED).entity(usuariosDTO).build();
	}

	@Override
	public Response iniciarSesion(UsuarioIniciarSesionDto usuarioValidacion) {				
		StringBuilder sb = null;
		String nombreUsuario = usuarioValidacion.getNombreUsuario();
		if (StringUtils.isBlank(nombreUsuario) || FuncionesUtilitarias.esClaveFormatoCorrecto(usuarioValidacion.getClave())) { 
			sb = new StringBuilder("FORMATO DE USUARIO/CLAVE INCORRECTO! Usuario: ");
			sb.append(nombreUsuario);
			log4j.fatal(sb.toString());
			return Response.ok().status(Response.Status.UNAUTHORIZED).entity(MensajesValidacion.CREDENCIALES_INCORRECTAS).build();
		}
		
		String claveEncriptada = null;
		try {
			claveEncriptada = FuncionesUtilitarias.encriptar(usuarioValidacion.getClave());
		} catch (UnsupportedEncodingException e1) {
			sb = new StringBuilder("ERROR AL DESENCRIPTAR CLAVE! Usuario:");
			sb.append(nombreUsuario);
			sb.append(" EXEPCION:");
			sb.append(e1.getMessage());
			log4j.fatal(sb.toString());
			return Response.status(Response.Status.UNAUTHORIZED).entity(MensajesValidacion.CREDENCIALES_INCORRECTAS).build();
		}
		
		Usuario usuario = usuarioDao.obtenerUsuarioPorNombreYClave(nombreUsuario, claveEncriptada);
		if (usuario == null) {
			sb = new StringBuilder("CREDENCIALES INCORRECTAS! Usuario:");
			sb.append(nombreUsuario);
			sb.append("y clave:");
			sb.append(usuarioValidacion.getClave());
			log4j.fatal(sb.toString());
			
			List<Usuario> usuariosPorNombreUsuario = usuarioDao.findByAttribute(nombreUsuario, "nombreUsuario");
			if (usuariosPorNombreUsuario != null && usuariosPorNombreUsuario.size() > 0) {
				usuario = usuariosPorNombreUsuario.get(0);
				Integer cantLogeosFallidos = usuario.getCantLogeosFallidos();
				Integer cantidadLogeosPermitidos = usuario.getCantLogeosPermitidos();
				if (cantLogeosFallidos >= cantidadLogeosPermitidos) {
					usuario.setActivo(false);
					sb = new StringBuilder("USUARIO SUPERA LOS ");
					sb.append(cantidadLogeosPermitidos);
					sb.append("INTENTOS FALLIDOS! Usuario:");					 
					sb.append( nombreUsuario);
					log4j.fatal(sb.toString());
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_EXCEDIO_LIMITE_CANTIDAD_LOGEOS).build();
				}
			cantLogeosFallidos = cantLogeosFallidos + 1;
			usuario.setCantLogeosFallidos(cantLogeosFallidos);
			usuarioDao.edit(usuario);
			}
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.CREDENCIALES_INCORRECTAS).build();
		}
		
		
		if (!usuario.getActivo()) {
			sb = new StringBuilder("USUARIO INACTIVO! Usuario:");
			sb.append(nombreUsuario);
			log4j.fatal(sb.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_INACTIVO).build();
		}
		
		String token = null;
		if (usuario != null) {
			String aplicacion = "Ruffo";
			DateTime fechaActual = DateTime.now();;
			Date fechaCreacion = fechaActual.toDate();
			Date fechaExpiracion = fechaActual.plusMinutes(60).toDate();            
			//Se define que el rol de usuario es el tipo de usuario. Momentanemente por alcance del proyecto
			List <Rol> roles = new ArrayList<>();
			Rol rol = new Rol();
			String tipoUsuario = usuario.getTipoUsuario().getDescripcion();
			rol.setNombreRol(tipoUsuario != null ? tipoUsuario : "NINGUNO");
			roles.add(rol);
			try {				
				Long idUsuario = usuario.getId();
				token = Jwts.builder()
						  .setSubject(nombreUsuario)
						  .setAudience(aplicacion)
						  .setIssuedAt(fechaCreacion)
						  .setExpiration(fechaExpiracion)
						  .claim("roles", roles) 
//						  .claim("tipoUsuario", tipoUsuario) 
//						  .claim("idUsuario", idUsuario) 
						  .signWith(SignatureAlgorithm.HS256, Constantes.KEY.getBytes("UTF-8")
						  ).compact();
				
				//Verifico que no tenga otras sesiones activas. Si la tiene la actualizo la última y cierro otras que pueda tener activas
				List<Sesion> sesionesActivas = sesionDao.obtenerSesionesDeUsuario(idUsuario, true);				
				Calendar calendar = Calendar.getInstance();
				java.sql.Date fecha = new java.sql.Date(calendar.getTime().getTime());
								
				boolean tieneSesionActiva = sesionesActivas != null && sesionesActivas.size() > 0 ? true : false;
				if (sesionesActivas != null && sesionesActivas.size() > 0) {		
					Collections.sort(sesionesActivas, Sesion.SesionFechaUltimopAccesoComparator);			
					for (Sesion sesion : sesionesActivas) {
						if (tieneSesionActiva && sesion.isActiva() && DateUtils.addMinutes(sesion.getFechaUltimoAcceso(), 60).after(new Date())) {
							sesion.setFechaUltimoAcceso(fecha);
							sesionDao.edit(sesion);
							tieneSesionActiva = true;
						}
						else {
							sesion.setActiva(false);
							sesionDao.edit(sesion);
						}
					}
				}				
				
				if (!tieneSesionActiva) {
					boolean activa = true;
					String ipCliente = "";				
					java.sql.Date fechaInicio = fecha;
					java.sql.Date fechaUltimoAcceso = fecha;				
					Sesion sesion = new Sesion(null, usuario, token, fechaInicio, fechaUltimoAcceso, activa, aplicacion, ipCliente);
					sesionDao.persist(sesion);
				}				
			} catch (UnsupportedEncodingException e) {
				sb = new StringBuilder("ERROR CON MANEJO DE JWT! ");
				sb.append("EXCEPCION:");
				sb.append(e.getMessage());
				log4j.fatal(sb.toString());
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.ERROR_LOGIN).build();
			}		
			Boolean actualizarClave = usuario.getActualizarClave() != null ? usuario.getActualizarClave() : false;
			usuario.setCantLogeosFallidos(0);
			usuario.setActualizarClave(false);
			usuarioDao.edit(usuario);
			UsuarioLogueadoDto usuarioLogueadoDto = new UsuarioLogueadoDto(usuario.getId(), nombreUsuario, tipoUsuario, token);
			if (actualizarClave) {
				return Response.status(Response.Status.OK).entity(usuarioLogueadoDto).build();
			}
			return Response.status(Response.Status.ACCEPTED).entity(usuarioLogueadoDto).build();
		}	
		sb = new StringBuilder("CREDENCIALES INCORRECTAS! Usuario: ");
		sb.append(nombreUsuario);
		sb.append("y clave:");
		sb.append(usuarioValidacion.getClave());
		log4j.fatal(sb.toString());
		return Response.ok().status(Response.Status.UNAUTHORIZED).entity(MensajesValidacion.CREDENCIALES_INCORRECTAS).build();
				
	}

	@Override
	public Response obtenerUsuarioPorId(Long id) throws SeguridadChequeoException, PrivilegiosChequeoException {
		Usuario usuario = usuarioDao.find(id);
		if (usuario == null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_CON_ID_INEXISTENTE).build(); 
		ModelMapper modelMapper = new ModelMapper();
		return null;
	}

	@Override
	public Response obtenertiposDeUsuario() {
		List <TipoUsuario> tiposDeUsurios = tipoUsuarioDao.findAll(1, 100);
		return Response.ok().status(Response.Status.ACCEPTED).entity(tiposDeUsurios).build();
	}

	@Override
	public Boolean validarNombreUsuarioYClave(String nombre, String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response activarUsuario(String eMail, String codigoConfirmacion) {
		StringBuilder sb = null;
		List <Usuario> usuarios = usuarioDao.findByAttribute(eMail, "eMail");
		if (usuarios == null || usuarios.size() < 1) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.ERROR_AL_ACTIVAR_CUENTA).build();
		}
		else {
			Usuario usuario = usuarios.get(0);
			String codigoActivacion = null;;
			try {
				codigoActivacion = FuncionesUtilitarias.desencriptar(usuario.getCodigoActivacion());
			} catch (UnsupportedEncodingException e) {
				sb = new StringBuilder("ERROR AL DESENCRIPTAR CODIGO DE ACTIVACION! Usuario:");
				sb.append(usuario.getNombre());
				sb.append(" EXEPCION:");
				sb.append(e.getMessage());
				log4j.fatal(sb.toString());
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.ERROR_CODIGO_ACTIVACION).build();
			}
			if (codigoActivacion == null || !codigoActivacion.equalsIgnoreCase(codigoConfirmacion)) {
				sb = new StringBuilder("ERROR AL ACTIVAR LA CUENTA! Usuario:");
				sb.append(usuario.getNombre());
				sb.append(" CODIGO DE CONFIRMACION:");
				sb.append(codigoConfirmacion);
				log4j.fatal(sb.toString());
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.ERROR_AL_ACTIVAR_CUENTA).build();
			}
			else {
				usuario.setActivo(true);
				usuario.setActualizarClave(false);
				usuarioDao.persist(usuario);
				return Response.ok().status(Response.Status.ACCEPTED).entity(MensajesValidacion.OPERACION_EXITOSA).build();
			}
		}
	}

	@Override
	public Response reenviarCodigoActivacionUsuario(String eMail) {
		StringBuilder sb = null;
		if (StringUtils.isBlank(eMail) || !(FuncionesUtilitarias.esMailFormatoCorrecto(eMail))) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.MAIL_CON_FORMATO_INCORRECTO).build();
		}
		
		List <Usuario> usuarios = usuarioDao.findByAttribute(eMail, "eMail");
		if (usuarios == null || usuarios.size() < 1) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_INEXISTENTE).build();
		}
		else {
			Usuario usuario = usuarios.get(0);
			usuario.setActivo(false);
			String codigoConfirmacion = FuncionesUtilitarias.crearCodigoActivacion();
			String codigoConfirmacionEncriptado = null;
			try {
				codigoConfirmacionEncriptado = FuncionesUtilitarias.encriptar(codigoConfirmacion);
			} catch (UnsupportedEncodingException e) {
				sb = new StringBuilder("ERROR AL DESENCRIPTAR CODIGO DE CONFIRMACION! Usuario:");
				sb.append(usuario.getNombre());
				sb.append(" EXEPCION:");
				sb.append(e.getMessage());
				log4j.fatal(sb.toString());
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.ERROR_CODIGO_ACTIVACION).build();
			}
			usuario.setCodigoActivacion(codigoConfirmacionEncriptado);
			usuarioDao.persist(usuario);			
			enviarMailConfirmacionDeCuenta(eMail, codigoConfirmacion);
			return Response.ok().status(Response.Status.ACCEPTED).entity(MensajesValidacion.OPERACION_EXITOSA).build();
		}
	}

	private void enviarMailConfirmacionDeCuenta(String eMail, String codigoConfirmacion) {
		StringBuilder sbMail = new StringBuilder(Constantes.MAIL_TIPO_CONFIRMACION_CUENTA.toString());
		sbMail.append(Constantes.MAIL_CARACTER_EXPECIAL_TIPO_MAIL);
		sbMail.append(eMail);
		sbMail.append(Constantes.MAIL_CARACTER_EXPECIAL_DESTINATARIO_MAIL);
		sbMail.append(codigoConfirmacion);
		encolardorMensajes.encolarMensaje(sbMail.toString());
	}

	@Override
	public Response cerrarSesion(String nombreUsuario) {
		StringBuilder sb = null;
		if (StringUtils.isBlank(nombreUsuario)) { 
			sb = new StringBuilder("FORMATO DE NOMBRE DE USUARIO INCORRECTO! Usuario: ");
			sb.append(nombreUsuario);
			log4j.fatal(sb.toString());
			return Response.ok().status(Response.Status.UNAUTHORIZED).entity(MensajesValidacion.CREDENCIALES_INCORRECTAS).build();
		}
		
		List<Usuario> usuarios = usuarioDao.findByAttribute(nombreUsuario, "nombreUsuario");
		Usuario usuario = null;
		if (usuarios == null || usuarios.size() < 1) {
			sb = new StringBuilder("Usuario inexistente! Usuario:");
			sb.append(nombreUsuario);
			log4j.fatal(sb.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_INEXISTENTE).build();
		}		
		usuario = usuarios.get(0);		
		String token = null;
		String tokenActualizado = null;
		if (usuario != null) {		
			List<Sesion> sesionesActivas = sesionDao.obtenerSesionesDeUsuario(usuario.getId(), true);				
			Calendar calendar = Calendar.getInstance();
			java.sql.Date fecha = new java.sql.Date(calendar.getTime().getTime());
							
			if (sesionesActivas != null && sesionesActivas.size() > 0) {		
				Collections.sort(sesionesActivas, Sesion.SesionFechaUltimopAccesoComparator);			
				for (Sesion sesion : sesionesActivas) {				
					sesion.setFechaUltimoAcceso(fecha);
					sesion.setActiva(false);
					token = sesion.getToken();
					if (StringUtils.isNotBlank(token)) {
						try {
							Jws<Claims> claims = Jwts.parser().setSigningKey(Constantes.KEY.getBytes("UTF-8")).parseClaimsJws(token);										
							DateTime fechaActual = DateTime.now();        		
							tokenActualizado = Jwts.builder()
									.setSubject(claims.getBody().getSubject())
									.setAudience(claims.getBody().getAudience())
									.setIssuedAt(claims.getBody().getIssuedAt())
									.setExpiration(fechaActual.toDate())
									.claim("roles", claims.getBody().get("roles"))
//									.claim("tipoUsuario", claims.getBody().get("tipoUsuario"))
//									.claim("idUsuario", claims.getBody().get("idUsuario"))
									.signWith(SignatureAlgorithm.HS256, Constantes.KEY.getBytes("UTF-8")).compact();
						} catch (UnsupportedEncodingException e) {
							log4j.error(e.getMessage());		
							return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.ERROR_AL_CERRAR_SESION, "Ocurrio un problema con el token.")).build();
						}	
						catch (ExpiredJwtException e2) {
							log4j.error(e2.getMessage());
						}
						
					}
					sesionDao.edit(sesion);
				}
			}		
			else 
				return Response.ok().status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.ERROR_AL_CERRAR_SESION, "El usuario no tiene sesiones activas.")).build();
		}
		return Response.ok().status(Response.Status.ACCEPTED).entity(tokenActualizado).build();
	}

	@Override
	public Response obtenerUsuarioPorNombre(String nombreUsuario) throws SeguridadChequeoException, PrivilegiosChequeoException {
		if (StringUtils.isBlank(nombreUsuario))
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.ERROR_PARAMETRO_VACIO, "nombre de usuario")).build();
		
		List<Usuario> usuariosPorNombre = usuarioDao.findByAttribute(nombreUsuario, "nombreUsuario");
		if (usuariosPorNombre == null || usuariosPorNombre.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_INEXISTENTE).build();
		
		Usuario usuario = usuariosPorNombre.get(0);
		Long id = usuario.getId();
		String nombre = usuario.getNombre();
		String apellido = usuario.getApellido();
		String ci = usuario.getCi();
		String domicilio = usuario.getDomicilio();
		String telefono = usuario.getTelefono();
		String celular = usuario.getCelular();
		String eMail = usuario.geteMail();
		Date fechaNacimiento = usuario.getFechaNacimiento();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String fechaString = sdf.format(fechaNacimiento);
		String tipoUsuario = usuario.getTipoUsuario().getDescripcion();
		String descripcionTipoUsuario = tipoUsuario;
		String imagen = usuario.getImagen();	
		String pais = usuario.getPais().getNombre();		
		String sexo = usuario.getSexo().getDescripcion();
		Integer cantLogeosPermitidos = usuario.getCantLogeosPermitidos();
		Integer cantLogeosFallidos = usuario.getCantLogeosFallidos();
		List<RolDto> roles = new ArrayList<RolDto>();
		List<Mascota> mascotas = usuarioDao.obtenerMascotasDeUsuario(id);
		List<MascotaDto> mascotasDto = new ArrayList<>();
		MascotaDto mascotaDto = null;
		if (mascotas != null && mascotas.size() > 0) {
			for (Mascota mascota : mascotas) {
				SexoMascota sexoM = mascota.getSexo();
				Raza razaM = mascota.getRaza();
				TipoMascota tipoMascotaM = mascota.getRaza().getTipoMascota();
				Color colorPredominanteM = mascota.getColorPredominante();
				Color colorSecundarioM = mascota.getColorSecundario();
				Tamanio tamanioM = mascota.getTamanio();
				Usuario propietario = mascota.getPropietario();
				List<String> imagenesString = obtenerStringDeImagenes(mascota);
				String estadoUltimoMascota = bpmMascotaDao.obtenerUltimoEstadoDeMascotaPorIdMascota(mascota.getId());
				mascotaDto = new MascotaDto(mascota.getId(), mascota.getNombre(), sexoM != null ? sexoM.getDescripcion() : null, razaM != null && tipoMascotaM != null ? tipoMascotaM.getDescripcion() : null, razaM != null ? razaM.getDescripcion() : null, tamanioM != null ? tamanioM.getDescripcion() : null, colorPredominanteM != null ? colorPredominanteM.getDescripcion() : null, colorSecundarioM != null ? colorSecundarioM.getDescripcion() : null, mascota.getNroChip(), mascota.getNroBeacon(), propietario != null ? propietario.geteMail() : null, mascota.getFechaNacimiento(), null, imagenesString, estadoUltimoMascota);
				mascotasDto.add(mascotaDto);
			}			
		}
		UsuarioDto usuarioDto = new UsuarioDto(id, nombreUsuario, null, nombre, apellido, ci, 
				domicilio, telefono, celular, eMail, fechaNacimiento, fechaString, descripcionTipoUsuario, imagen, pais, cantLogeosPermitidos, cantLogeosFallidos, roles, mascotasDto, sexo);
		return Response.status(Response.Status.OK).entity(usuarioDto).build();
	}
	
	private List<String> obtenerStringDeImagenes(Mascota mascota) {
		List<String> imagenesString = new ArrayList<>();
		List<Imagen> imagenes = mascota.getImagenes();
		int contador = imagenes.size();
		for (Imagen imagen : imagenes) {
			if (StringUtils.isNotBlank(imagen.getImagen()) && contador == 1)
				imagenesString.add(imagen.getImagen());
			contador --;
		}
		return imagenesString;
	}

	@Override
	public Response olvidoDeClave(String nombreUsuario) {
		StringBuilder sb = null;
		if (StringUtils.isBlank(nombreUsuario)) 
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.ERROR_PARAMETRO_VACIO, "mail del usuario")).build();
		
		List<Usuario> usuarios = usuarioDao.findByAttribute(nombreUsuario, "nombreUsuario");
		Usuario usuario = null;
		if (usuarios == null || usuarios.size() < 1) {
			sb = new StringBuilder("Usuario inexistente! Usuario:");
			sb.append(nombreUsuario);
			log4j.fatal(sb.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_INEXISTENTE).build();
		}		
		usuario = usuarios.get(0);
		usuario.setActualizarClave(true);
		
		//Validación de extensión y formato de clave
		String clave = FuncionesUtilitarias.getPassword(7);
		String claveEncriptada = null;
		if (FuncionesUtilitarias.esClaveFormatoCorrecto(clave))
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.FORMATO_CLAVE_INCORRECTO).build();
		else {
			try {
				claveEncriptada = FuncionesUtilitarias.encriptar(clave);
			} catch (UnsupportedEncodingException e) {
				log4j.fatal(e.getMessage());
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.FORMATO_CLAVE_INCORRECTO).build();
			}
		}
		usuario.setClave(claveEncriptada);				
		usuarioDao.edit(usuario);
		enviarMailClaveTemporal(usuario.geteMail(), clave);
		return Response.status(Response.Status.OK).entity(MensajesValidacion.OPERACION_EXITOSA).build();
	}
	
	private void enviarMailClaveTemporal(String eMail, String clave) {
		StringBuilder sbMail = new StringBuilder(Constantes.MAIL_TIPO_REENVIO_CLAVE.toString());
		sbMail.append(Constantes.MAIL_CARACTER_EXPECIAL_TIPO_MAIL);
		sbMail.append(eMail);
		sbMail.append(Constantes.MAIL_CARACTER_EXPECIAL_DESTINATARIO_MAIL);
		sbMail.append(clave);
		encolardorMensajes.encolarMensaje(sbMail.toString());
	}

	@Override
	public Response modificarClave(UsuarioIniciarSesionDto usuarioIniciarSesion) {
		String nombreUsuario = usuarioIniciarSesion.getNombreUsuario();
		StringBuilder sb = null;
		if (StringUtils.isBlank(nombreUsuario)) 
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.ERROR_PARAMETRO_VACIO, "mail del usuario")).build();
		
		List<Usuario> usuarios = usuarioDao.findByAttribute(nombreUsuario, "nombreUsuario");
		Usuario usuario = null;
		if (usuarios == null || usuarios.size() < 1) {
			sb = new StringBuilder("Usuario inexistente! Usuario:");
			sb.append(nombreUsuario);
			log4j.fatal(sb.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_INEXISTENTE).build();
		}		
		usuario = usuarios.get(0);		
		//Validación de extensión y formato de clave
		String clave = usuarioIniciarSesion.getClave();
		String claveEncriptada = null;
		if (FuncionesUtilitarias.esClaveFormatoCorrecto(clave))
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.FORMATO_CLAVE_INCORRECTO).build();
		else {
			try {
				claveEncriptada = FuncionesUtilitarias.encriptar(clave);
			} catch (UnsupportedEncodingException e) {
				log4j.fatal(e.getMessage());
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.FORMATO_CLAVE_INCORRECTO).build();
			}
		}
		usuario.setClave(claveEncriptada);
		usuarioDao.edit(usuario);
		return Response.status(Response.Status.OK).entity(MensajesValidacion.OPERACION_EXITOSA).build();
	}
}
