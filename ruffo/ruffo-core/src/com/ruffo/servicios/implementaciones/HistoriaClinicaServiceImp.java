package com.ruffo.servicios.implementaciones;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;

import com.ruffo.dao.ConsultaClinicaDao;
import com.ruffo.dao.HistoriaClinicaDao;
import com.ruffo.dao.MascotaDao;
import com.ruffo.dao.UsuarioDao;
import com.ruffo.dto.ConsultaClinicaDto;
import com.ruffo.dto.HistoriaClinicaDto;
import com.ruffo.entidades.ConsultaClinica;
import com.ruffo.entidades.HistoriaClinica;
import com.ruffo.entidades.Mascota;
import com.ruffo.entidades.Usuario;
import com.ruffo.mensajes.MensajesValidacion;
import com.ruffo.servicios.interfaces.HistoriaClinicaService;
import com.ruffo.utils.PrivilegiosChequeoException;
import com.ruffo.utils.SeguridadChequeoException;

@Stateless
public class HistoriaClinicaServiceImp implements HistoriaClinicaService {

	@Inject
	HistoriaClinicaDao historiaClinicaDao;
	
	@Inject
	MascotaDao mascotaDao;
	
	@Inject
	UsuarioDao usuarioDao;
	
	@Inject
	ConsultaClinicaDao consultaClinicaDao;
	
	private static String NO_DEFINIDO = "NO DEFINIDO";
	
	private static String NO_INGRESADO = "NO INGRESADO";
	
	@Override
	public Response agregarHistoriaClinica(HistoriaClinicaDto historiaClinicaDto) {
		
		Long idMascota = historiaClinicaDto.getIdMascota();
		if (idMascota == null || idMascota < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.ERROR_PARAMETRO_VACIO, "id de mascota")).build();
		
		Mascota mascota = mascotaDao.find(idMascota);
		if (mascota == null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.MASCOTA_INEXISTENTE)).build();
		
		String nombreUsuario = historiaClinicaDto.getNombreUsuario();
		if (StringUtils.isBlank(nombreUsuario))
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.ERROR_PARAMETRO_VACIO, "el nombre del usuario")).build();
	
		List<Usuario> findByAttributeUsuarios = usuarioDao.findByAttribute(nombreUsuario, "nombreUsuario");
		if (findByAttributeUsuarios == null || findByAttributeUsuarios.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.MASCOTA_NO_PERTENECE_AL_USUARIO, idMascota, nombreUsuario)).build();
		
		Usuario usuario = findByAttributeUsuarios.get(0);
		if (usuario.getTipoUsuario().getDescripcion().equalsIgnoreCase("NORMAL")) {
			Long idUsuarioPropietario = usuario.getId();
			List <Mascota> mascotasDeUsuario = usuarioDao.obtenerMascotasDeUsuario(idUsuarioPropietario);
			if (mascotasDeUsuario == null || mascotasDeUsuario.size() < 1)
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.MASCOTA_NO_PERTENECE_AL_USUARIO, idMascota, nombreUsuario)).build();			
		}
			
		List<HistoriaClinica> historiaClinicaDeMascota = historiaClinicaDao.obtenerHistoriaClinicaDeMascotaPaginado(idMascota, 1, 1);
		HistoriaClinica historiaClinica = null;
		if (historiaClinicaDeMascota != null && historiaClinicaDeMascota.size() > 0) 
			historiaClinica = historiaClinicaDeMascota.get(0);			
		else 
			historiaClinica = new HistoriaClinica();			
		
		List<ConsultaClinicaDto> consultas = historiaClinicaDto.getConsultas();		
		historiaClinica.setMascota(mascota);
		
		// Tener en cuenta que en modificar se realiza lo mismo. Ver de hace refactor. Está el problema del return
		List<ConsultaClinica> consultasClinicas = new ArrayList<>();
		ConsultaClinica consultaClinica = null;
		String descripcionTipoUsuario = null;
		String diagnostico = null;
		Date fechaConsulta = null;

		if (consultas != null && consultas.size() > 0) {		
			
			for (ConsultaClinicaDto consultaDto : consultas) {
				consultaClinica = new ConsultaClinica();
				diagnostico = StringUtils.isNotBlank(consultaDto.getDiagnostico()) ? consultaDto.getDiagnostico() : NO_INGRESADO;
				consultaClinica.setDiagnostico(diagnostico);
				
				fechaConsulta = consultaDto.getFecha() != null ? consultaDto.getFecha() : new Date();
				consultaClinica.setFecha(fechaConsulta);
				
				String motivoConsulta = StringUtils.isNotBlank(consultaDto.getMotivoConsulta()) ? consultaDto.getMotivoConsulta() : NO_INGRESADO;
				consultaClinica.setMotivoConsulta(motivoConsulta);
				
				consultaClinica.setUsuario(usuario);
				
				String tratamiento = StringUtils.isNotBlank(consultaDto.getTratamiento()) ? consultaDto.getTratamiento() : NO_INGRESADO;
				consultaClinica.setTratamiento(tratamiento);
				
				consultaClinica.setHistoria(historiaClinica);
				
				consultasClinicas.add(consultaClinica);
				
				//Se setea el tipo de usuario para distinguirlo por colores en la UI
				descripcionTipoUsuario = usuario.getTipoUsuario() != null ? usuario.getTipoUsuario().getDescripcion() : NO_DEFINIDO;
				consultaDto.setTipoUsuario(descripcionTipoUsuario);
			}				
		}		
		
		// Es una historia clinica nueva
		if (historiaClinica.getId() == null) {
			historiaClinica.setConsultas(consultasClinicas);
			historiaClinicaDao.persist(historiaClinica);
		}
		else {
			for (ConsultaClinica consulta: consultasClinicas) {
				historiaClinica.getConsultas().add(consulta);
			}
			historiaClinicaDao.edit(historiaClinica);
		}
		if (historiaClinica != null && historiaClinica.getConsultas() != null && historiaClinica.getConsultas().size() > 0)
			historiaClinicaDto.getConsultas().sort(Comparator.comparing(ConsultaClinicaDto::getFecha).reversed());
		return Response.status(Response.Status.OK).entity(historiaClinicaDto).build();
	}

	@Override
	public Response modificarConsultaClinica(HistoriaClinicaDto historiaClinicaDto) throws SeguridadChequeoException, PrivilegiosChequeoException {
		Long idMascota = historiaClinicaDto.getIdMascota();
		if (idMascota == null || idMascota < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.ERROR_PARAMETRO_VACIO, "id de mascota")).build();
		
		List<ConsultaClinicaDto> consultas = historiaClinicaDto.getConsultas();
		if (consultas == null || consultas.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.ERROR_PARAMETRO_VACIO, "lineas de historia clinica")).build();
		
		String nombreUsuario = historiaClinicaDto.getNombreUsuario();
		if (StringUtils.isBlank(nombreUsuario))
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.ERROR_PARAMETRO_VACIO, "el nombre del usuario")).build();
	
		List<Usuario> findByAttributeUsuarios = usuarioDao.findByAttribute(nombreUsuario, "nombreUsuario");
		if (findByAttributeUsuarios == null || findByAttributeUsuarios.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.MASCOTA_NO_PERTENECE_AL_USUARIO, idMascota, nombreUsuario)).build();
		
		Usuario findUsuario = findByAttributeUsuarios.get(0);
		Long idUsuarioPropietario = findUsuario.getId();
		
		if (findUsuario.getTipoUsuario().getDescripcion().equalsIgnoreCase("NORMAL")) {
			List <Mascota> mascotasDeUsuario = usuarioDao.obtenerMascotasDeUsuario(idUsuarioPropietario);
			if (mascotasDeUsuario == null || mascotasDeUsuario.size() < 1)
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.MASCOTA_NO_PERTENECE_AL_USUARIO, idMascota, idUsuarioPropietario)).build();			
		}		
		
		ConsultaClinica consultaClinica = null;
		String diagnostico = null;
		Date fechaConsulta = null;
		String descripcionTipoUsuario = null;
		
		for (ConsultaClinicaDto consultaDto : consultas) {
			Long idConsulta = consultaDto.getId();
			if (idConsulta == null)
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_REQUERIDO, "id consulta clinica")).build();
			
			consultaClinica = consultaClinicaDao.find(consultaDto.getId());	
			if (consultaClinica.getUsuario().getId() != idUsuarioPropietario)
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.CONSULTA_NO_EDITABLE_PARA_USUARIO).build();
		}
		
		
		for (ConsultaClinicaDto consultaDto : consultas) {
			consultaClinica = consultaClinicaDao.find(consultaDto.getId());			
			diagnostico = StringUtils.isNotBlank(consultaDto.getDiagnostico()) ? consultaDto.getDiagnostico() : NO_INGRESADO;
			consultaClinica.setDiagnostico(diagnostico);
			
			fechaConsulta = consultaDto.getFecha() != null ? consultaDto.getFecha() : new Date();
			consultaClinica.setFecha(fechaConsulta);
			
			String motivoConsulta = StringUtils.isNotBlank(consultaDto.getMotivoConsulta()) ? consultaDto.getMotivoConsulta() : NO_INGRESADO;
			consultaClinica.setMotivoConsulta(motivoConsulta);
			
			consultaClinica.setUsuario(findUsuario);
			
			consultaClinica.setTratamiento(StringUtils.isNotBlank(consultaDto.getTratamiento()) ? consultaDto.getTratamiento() : NO_INGRESADO);
			consultaClinicaDao.edit(consultaClinica);
			
			//Se setea el tipo de usuario para distinguirlo por colores en la UI
			descripcionTipoUsuario = findUsuario.getTipoUsuario() != null ? findUsuario.getTipoUsuario().getDescripcion() : NO_DEFINIDO;
			consultaDto.setTipoUsuario(descripcionTipoUsuario);
		}
		if (historiaClinicaDto != null && historiaClinicaDto.getConsultas() != null && historiaClinicaDto.getConsultas().size() > 0)
			historiaClinicaDto.getConsultas().sort(Comparator.comparing(ConsultaClinicaDto::getFecha).reversed());
		return Response.status(Response.Status.OK).entity(historiaClinicaDto).build();
	}

	@Override
	public Response obtenerHistoriasClinicasDeMascota(Long idMascota, Integer nroPagina, Integer cantPorPagina) throws SeguridadChequeoException, PrivilegiosChequeoException {
		if (idMascota == null || idMascota < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.ERROR_PARAMETRO_VACIO, "id de mascota")).build();
		
		List<HistoriaClinica> historiasClinicas = historiaClinicaDao.obtenerHistoriaClinicaDeMascotaPaginado(idMascota, nroPagina, cantPorPagina);
		HistoriaClinica historiaClinica = null;
		HistoriaClinicaDto historiaClinicaDto = new HistoriaClinicaDto();
		if (historiasClinicas != null && historiasClinicas.size() > 0) {
			historiaClinicaDto = new HistoriaClinicaDto();
			historiaClinica = historiasClinicas.get(0);
			List<ConsultaClinicaDto> consultasDto = null;
			List<ConsultaClinica> consultas = historiaClinica.getConsultas();
			if (consultas != null && consultas.size() > 0) {
				consultasDto = new ArrayList<>();
				
				for (ConsultaClinica consultaClinica : consultas) {
					Long idConsulta = consultaClinica.getId();
					Long idUsuario = consultaClinica.getUsuario().getId();
					String tipoDeUsuario = consultaClinica.getUsuario().getTipoUsuario().getDescripcion();
					StringBuilder sbNombreUsuario = new StringBuilder();
					Usuario usuario = usuarioDao.find(idUsuario);
					if (tipoDeUsuario.equalsIgnoreCase("VETERINARIO")) {
						sbNombreUsuario.append(usuario.getNombre());
						sbNombreUsuario.append(" ");
						sbNombreUsuario.append(usuario.getApellido());						
					}
					String motivoConsulta = consultaClinica.getMotivoConsulta();
					String diagnostico = consultaClinica.getDiagnostico();
					String tratamiento = consultaClinica.getTratamiento();
					Date fecha = consultaClinica.getFecha();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
					String fechaString = sdf.format(fecha);
					ConsultaClinicaDto e = new ConsultaClinicaDto(idConsulta, idUsuario, tipoDeUsuario, motivoConsulta, diagnostico, tratamiento, fecha, fechaString, sbNombreUsuario.toString());
					consultasDto.add(e);
				}				
			}
			
			historiaClinicaDto = new HistoriaClinicaDto(historiaClinica.getId(), historiaClinica.getMascota().getId(), consultasDto);			
			if (historiaClinicaDto != null && historiaClinicaDto.getConsultas() != null && historiaClinicaDto.getConsultas().size() > 0)
				historiaClinicaDto.getConsultas().sort(Comparator.comparing(ConsultaClinicaDto::getFecha).reversed());
		}	
		return Response.status(Response.Status.OK).entity(historiaClinicaDto).build();
	}

	@Override
	public Response obtenerConsultaClinicaPorId(Long id) throws SeguridadChequeoException, PrivilegiosChequeoException {
		if (id == null || id < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.ERROR_PARAMETRO_VACIO, "id de consulta clinica")).build();
		ConsultaClinica consultaClinica = consultaClinicaDao.find(id);
		if (consultaClinica == null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.CONSULTA_CLINICA_INEXISTENTE)).build();
		
		Long id2 = consultaClinica.getId();
		Usuario usuario = consultaClinica.getUsuario();
		Long id3 = usuario.getId();
		String tipoDeUsuario = usuario.getTipoUsuario().getDescripcion();
		StringBuilder sbNombreUsuario = new StringBuilder();		
		if (tipoDeUsuario.equalsIgnoreCase("VETERINARIO")) {
			sbNombreUsuario.append(usuario.getNombre());
			sbNombreUsuario.append(" ");
			sbNombreUsuario.append(usuario.getApellido());
		}
		String motivoConsulta = consultaClinica.getMotivoConsulta();
		String diagnostico = consultaClinica.getDiagnostico();
		String tratamiento = consultaClinica.getTratamiento();
		Date fecha = consultaClinica.getFecha();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String fechaString = sdf.format(fecha);
		ConsultaClinicaDto consultaClinicaDto = new ConsultaClinicaDto(id2, id3, tipoDeUsuario, motivoConsulta, diagnostico, tratamiento, fecha, fechaString, sbNombreUsuario.toString());
		return Response.status(Response.Status.OK).entity(consultaClinicaDto).build();
	}

	@Override
	public Response eliminarConsultaClinicaPorId(Long idConsultaClinica, String nombreUsuario) throws SeguridadChequeoException, PrivilegiosChequeoException {
		
		if (idConsultaClinica == null || idConsultaClinica < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.ERROR_PARAMETRO_VACIO, "id de consulta clinica")).build();
		
		if (StringUtils.isBlank(nombreUsuario))
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.ERROR_PARAMETRO_VACIO, "nombre de usuario")).build();
	
		ConsultaClinica cClinica = consultaClinicaDao.find(idConsultaClinica);
		if (cClinica == null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.CONSULTA_CLINICA_INEXISTENTE)).build();
		
		HistoriaClinica historia = cClinica.getHistoria();
		consultaClinicaDao.remove(cClinica);
		
		if (historia == null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.HISTORIA_CLINICA_INVALIDA)).build();
		
		Usuario usuario = null;
		List<Usuario> usuarios = usuarioDao.findByAttribute(nombreUsuario, "nombreUsuario");
		if (usuarios == null || usuarios.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_INEXISTENTE).build();			
		usuario = usuarios.get(0);		
		
		List<ConsultaClinica> consultas = historia.getConsultas();
		for (ConsultaClinica consultaClinica : consultas) {
			Long id = consultaClinica.getId();
			if (id.intValue() == idConsultaClinica.intValue()) {
				if (!consultaClinica.getUsuario().getNombreUsuario().equalsIgnoreCase(nombreUsuario))
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.CONSULTA_NO_EDITABLE_PARA_USUARIO).build();
				historia.getConsultas().remove(consultaClinica);
				break;
			}
		}	
		
		consultas = historia.getConsultas();
		HistoriaClinicaDto historiaClinicaDto = null;
		List<ConsultaClinicaDto> consultasDto = null;
		if (consultas != null && consultas.size() > 0) {
			historiaClinicaDto = new HistoriaClinicaDto();
			consultasDto = new ArrayList<>();
			for (ConsultaClinica consultaClinica : consultas) {
				Long idConsulta = consultaClinica.getId();
				Long idUsuario = consultaClinica.getUsuario().getId();
				String tipoDeUsuario = consultaClinica.getUsuario().getTipoUsuario().getDescripcion();
				StringBuilder sbNombreUsuario = new StringBuilder();
				Usuario usuarioConsulta = usuarioDao.find(idUsuario);
				if (tipoDeUsuario.equalsIgnoreCase("VETERINARIO")) {
					sbNombreUsuario.append(usuarioConsulta.getNombre());
					sbNombreUsuario.append(" ");
					sbNombreUsuario.append(usuarioConsulta.getApellido());
				}
				String motivoConsulta = consultaClinica.getMotivoConsulta();
				String diagnostico = consultaClinica.getDiagnostico();
				String tratamiento = consultaClinica.getTratamiento();
				Date fecha = consultaClinica.getFecha();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				String fechaString = sdf.format(fecha);
				ConsultaClinicaDto e = new ConsultaClinicaDto(idConsulta, idUsuario, tipoDeUsuario, motivoConsulta, diagnostico, tratamiento, fecha, fechaString, sbNombreUsuario.toString());
				consultasDto.add(e);
			}			
			if (historiaClinicaDto != null && historiaClinicaDto.getConsultas() != null && historiaClinicaDto.getConsultas().size() > 0)
				historiaClinicaDto.getConsultas().sort(Comparator.comparing(ConsultaClinicaDto::getFecha).reversed());
		}
		historiaClinicaDto = new HistoriaClinicaDto(historia.getId(), historia.getMascota().getId(), consultasDto);		
		return Response.status(Response.Status.OK).entity(historiaClinicaDto).build();
	}

	@Override
	public Response agregarConsultaClinica(Long idHistoria,  ConsultaClinicaDto consultaDto) throws SeguridadChequeoException, PrivilegiosChequeoException {
		if (idHistoria == null || idHistoria < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.ERROR_PARAMETRO_VACIO, "id de historia clinica")).build();
		
		HistoriaClinica findHistoria = historiaClinicaDao.find(idHistoria);
		if (findHistoria == null) 
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.HISTORIA_CLINICA_INVALIDA).build();
			
		if (consultaDto == null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.ERROR_PARAMETRO_VACIO, "line de historia clinica")).build();
		
		Long idUsuario = consultaDto.getIdUsuario();
		Usuario usuario = usuarioDao.find(idUsuario);
		if (usuario == null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_CON_ID_INEXISTENTE).build();			
		
		if (usuario.getTipoUsuario().getDescripcion().equalsIgnoreCase("NORMAL")) {
			List <Mascota> mascotasDeUsuario = usuarioDao.obtenerMascotasDeUsuario(idUsuario);
			if (mascotasDeUsuario == null || mascotasDeUsuario.size() < 1)
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.MASCOTA_NO_PERTENECE_AL_USUARIO, findHistoria.getMascota().getId(), idUsuario)).build();			
		}
	
		List<ConsultaClinica> consultasClinicas = new ArrayList<>();
		ConsultaClinica consultaClinica = null;
		String descripcionTipoUsuario = null;
		String diagnostico = null;
		Date fechaConsulta = null;		
			
		consultaClinica = new ConsultaClinica();
		diagnostico = StringUtils.isNotBlank(consultaDto.getDiagnostico()) ? consultaDto.getDiagnostico() : NO_INGRESADO;
		consultaClinica.setDiagnostico(diagnostico);
		
		fechaConsulta = consultaDto.getFecha() != null ? consultaDto.getFecha() : new Date();
		consultaClinica.setFecha(fechaConsulta);
		
		String motivoConsulta = StringUtils.isNotBlank(consultaDto.getMotivoConsulta()) ? consultaDto.getMotivoConsulta() : NO_INGRESADO;
		consultaClinica.setMotivoConsulta(motivoConsulta);
		
		consultaClinica.setUsuario(usuario);
		
		String tratamiento = StringUtils.isNotBlank(consultaDto.getTratamiento()) ? consultaDto.getTratamiento() : NO_INGRESADO;
		consultaClinica.setTratamiento(tratamiento);
		consultasClinicas.add(consultaClinica);
		
		//Se setea el tipo de usuario para distinguirlo por colores en la UI
		descripcionTipoUsuario = usuario.getTipoUsuario() != null ? usuario.getTipoUsuario().getDescripcion() : NO_DEFINIDO;
		consultaDto.setTipoUsuario(descripcionTipoUsuario);							

		findHistoria.getConsultas().add(consultaClinica);
		historiaClinicaDao.edit(findHistoria);
		consultaDto.setId(consultaClinica.getId());
		return Response.status(Response.Status.OK).entity(consultaDto).build();
	}

	@Override
	public Response obtenerConsultasClinicaDeMascota(Long idMascota, Integer nroPagina, Integer cantPorPagina) throws SeguridadChequeoException, PrivilegiosChequeoException {
		if (idMascota == null || idMascota < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.ERROR_PARAMETRO_VACIO, "id de mascota")).build();
		
		List<ConsultaClinica> consultas = consultaClinicaDao.obtenerConsultasClinicaDeMascota(idMascota, nroPagina, cantPorPagina);
		List<ConsultaClinicaDto> consultasDto = new ArrayList<>();
		for (ConsultaClinica consultaClinica : consultas) {
			Long idConsulta = consultaClinica.getId();
			Long idUsuario = consultaClinica.getUsuario().getId();
			String tipoDeUsuario = consultaClinica.getUsuario().getTipoUsuario().getDescripcion();
			StringBuilder sbNombreUsuario = new StringBuilder();
			Usuario usuarioConsulta = usuarioDao.find(idUsuario);
			if (tipoDeUsuario.equalsIgnoreCase("VETERINARIO")) {
				sbNombreUsuario.append(usuarioConsulta.getNombre());
				sbNombreUsuario.append(" ");
				sbNombreUsuario.append(usuarioConsulta.getApellido());
			}
			String motivoConsulta = consultaClinica.getMotivoConsulta();
			String diagnostico = consultaClinica.getDiagnostico();
			String tratamiento = consultaClinica.getTratamiento();
			Date fecha = consultaClinica.getFecha();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			String fechaString = sdf.format(fecha);
			ConsultaClinicaDto e = new ConsultaClinicaDto(idConsulta, idUsuario, tipoDeUsuario, motivoConsulta, diagnostico, tratamiento, fecha, fechaString, sbNombreUsuario.toString());
			consultasDto.add(e);
		}		
		if (consultasDto != null && consultasDto.size() > 0)
			consultasDto.sort(Comparator.comparing(ConsultaClinicaDto::getFecha).reversed());
		return Response.status(Response.Status.OK).entity(consultasDto).build();
	}

}
