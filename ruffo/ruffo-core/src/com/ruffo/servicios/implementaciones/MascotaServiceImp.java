package com.ruffo.servicios.implementaciones;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.ruffo.dao.ActividadMascotaDao;
import com.ruffo.dao.BPMMascotaDao;
import com.ruffo.dao.CaracteristaEspecialDao;
import com.ruffo.dao.ColorDao;
import com.ruffo.dao.HistoriaClinicaDao;
import com.ruffo.dao.LocalidadDao;
import com.ruffo.dao.MascotaDao;
import com.ruffo.dao.RazaDao;
import com.ruffo.dao.SexoMascotaDao;
import com.ruffo.dao.TamanioDao;
import com.ruffo.dao.TipoMascotaDao;
import com.ruffo.dao.UsuarioDao;
import com.ruffo.dto.MascotaDto;
import com.ruffo.dto.MascotaPerdidaDto;
import com.ruffo.dto.PublicarMascotaPerdidaDto;
import com.ruffo.entidades.ActividadMascota;
import com.ruffo.entidades.BPMMascota;
import com.ruffo.entidades.CaracteristicaEspecial;
import com.ruffo.entidades.CaracteristicaEspecialTemporal;
import com.ruffo.entidades.Color;
import com.ruffo.entidades.HistoriaClinica;
import com.ruffo.entidades.Imagen;
import com.ruffo.entidades.Localidad;
import com.ruffo.entidades.Mascota;
import com.ruffo.entidades.Raza;
import com.ruffo.entidades.SexoMascota;
import com.ruffo.entidades.Tamanio;
import com.ruffo.entidades.TipoMascota;
import com.ruffo.entidades.Usuario;
import com.ruffo.mensajes.MensajesValidacion;
import com.ruffo.servicios.interfaces.MascotaService;
import com.ruffo.utils.Constantes;
import com.ruffo.utils.EncolaMensaje;
import com.ruffo.utils.PrivilegiosChequeoException;
import com.ruffo.utils.RuffoConfig;
import com.ruffo.utils.SeguridadChequeoException;
import com.ruffo.utils.Service;
import com.ruffo.validadores.AgregarMascotaValidador;

@Stateless
public class MascotaServiceImp implements MascotaService{
	
	@Inject
	MascotaDao mascotaDao;
	
	@Inject
	UsuarioDao usuarioDao;
	
	@Inject
	HistoriaClinicaDao historiaClinicaDao;
	
	@Inject
	TipoMascotaDao tipoMascotaDao;
	
	@Inject
	RazaDao razaDao;
	
	@Inject
	TamanioDao tamanioMascotaDao;
	
	@Inject
	SexoMascotaDao sexoMascotaDao;
	
	@Inject
	ColorDao colorMascotaDao;
	
	@Inject
	LocalidadDao localidadDao;
	
	@Inject
	BPMMascotaDao bpmMascotaDao;
	
	@Inject
	ActividadMascotaDao actividadMascotaDao;
	
	@Inject
	CaracteristaEspecialDao caracteristaEspecialDao;
	
	@Inject
	EncolaMensaje encolardorMensajes;
	
	static Logger log4j = Logger.getLogger(MascotaServiceImp.class);

	@Override
	@Service(validatorClass = AgregarMascotaValidador.class)
	public Response agregarMascota(MascotaDto mascotaDto) throws SeguridadChequeoException, PrivilegiosChequeoException  {
		String nombre = mascotaDto.getNombre();
		String nombreMascota = nombre !=null ? nombre : "";
		
		String sexo = mascotaDto.getSexo();
		if (StringUtils.isBlank(sexo))
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_REQUERIDO, "sexo de la mascota")).build();
		List<SexoMascota> sexosDeMascota = sexoMascotaDao.findByAttribute(sexo, "descripcion");
		if (sexosDeMascota == null || sexosDeMascota.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.SEXO_INCORRECTO, "sexo de la mascota")).build();
		SexoMascota sexoMascota = sexosDeMascota.get(0);
		
		String nroChip = mascotaDto.getNroChip();
		if (StringUtils.isNotBlank(nroChip)) {
			List<Mascota> mascotasPorNroChip = mascotaDao.findByAttribute(nroChip, "nroChip");
			if (mascotasPorNroChip != null && mascotasPorNroChip.size() > 0)
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.MASCOTA_CON_NRO_CHIP_EXISTENTE)).build();
		}
		String nroChipMascota  = nroChip;
		
		String nroBeacon = mascotaDto.getNroBeacon();
		if (StringUtils.isNotBlank(nroBeacon)) {
			List<Mascota> mascotasPorNroBeacon = mascotaDao.findByAttribute(nroBeacon, "nroBeacon");
			if (mascotasPorNroBeacon != null && mascotasPorNroBeacon.size() > 0)
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.MASCOTA_CON_NRO_BEACON_EXISTENTE)).build();
		}
		String nroBeaconMascota = nroBeacon !=null ? nroBeacon : "";
		
		Usuario propietario = null;
		String eMailPropietario = mascotaDto.getPropietario();
		if (StringUtils.isNotBlank(eMailPropietario)) {
			List<Usuario> usuariosPorMail = usuarioDao.findByAttribute(eMailPropietario, "eMail");
			if (usuariosPorMail == null || usuariosPorMail.size() < 1)
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PROPIETARIO_INEXISTENTE)).build();
			propietario = usuariosPorMail.get(0);
		}
		
		TipoMascota tipo = null;
		String tipoMascota = mascotaDto.getTipo();		
		if (StringUtils.isNotBlank(tipoMascota)) {
			List<TipoMascota> tiposDeMascotas = tipoMascotaDao.findByAttribute(tipoMascota, "descripcion");
			if (tiposDeMascotas != null && tiposDeMascotas.size() > 0) {
				for (TipoMascota tipoM : tiposDeMascotas) {
					if (tipoM.getDescripcion().equalsIgnoreCase(tipoMascota))
						tipo = tipoM;
				}		
				if (tipo == null)
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.TIPO_DE_MASCOTA_INEXISTENTE)).build();
			}
			else
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.TIPOS_DE_MASCOTAS_INEXISTENTES)).build();
		}
		else 
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_REQUERIDO, "tipo de mascota")).build();
		
		Raza razaMascota = null;
		List<Raza> razasMascotas = razaDao.obtenerRazasPorTipoDeMascota(tipo.getDescripcion());
		if (razasMascotas == null || razasMascotas.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.RAZA_INEXISTENTE)).build();
		for (Raza raza : razasMascotas) {
			if (raza.getDescripcion().equalsIgnoreCase(mascotaDto.getRaza()))
				razaMascota = raza;
		}
		if (razaMascota == null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.RAZA_INEXISTENTE)).build();
		
		Tamanio tamanio = null;
		String tamanioMascota = mascotaDto.getTamanio();	
		if (StringUtils.isNotBlank(tamanioMascota)) {
			List<Tamanio> tamaniosDeMascotas = tamanioMascotaDao.findByAttribute(tamanioMascota, "descripcion");
			if (tamaniosDeMascotas == null || tamaniosDeMascotas.size() < 1)
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.TAMANIO_DE_MASCOTA_INEXISTENTE)).build();
			tamanio = tamaniosDeMascotas.get(0);
		}
		else 
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_REQUERIDO, "tamaño de mascota")).build();
		
		
		Color colorPredominante =  null;
		Color colorSecundario =  null;
		String colorPredominanteMascota = mascotaDto.getColorPredominante();	
		String colorSecundarioMascota = mascotaDto.getColorSecundario();	
		if (StringUtils.isNotBlank(colorPredominanteMascota) || StringUtils.isNotBlank(colorSecundarioMascota)) {
			List<Color> coloresPredominantesDeMascotas = colorMascotaDao.obtenerColorPorTipoYDescripcion("P", colorPredominanteMascota);
			List<Color> coloresSecundariosDeMascotas = colorMascotaDao.obtenerColorPorTipoYDescripcion("S", colorSecundarioMascota);
			if (coloresPredominantesDeMascotas == null || coloresPredominantesDeMascotas.size() < 1 || coloresSecundariosDeMascotas == null || coloresSecundariosDeMascotas.size() < 1)
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.COLORES_MASCOTAS_INVALIDOS).build();
			colorPredominante = coloresPredominantesDeMascotas.get(0);
			colorSecundario = coloresSecundariosDeMascotas.get(0);
		}
		else
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETROS_REQUERIDOS, "colores de la mascota")).build();
		
		Date fechaNacimiento = mascotaDto.getFechaNacimiento() != null ? mascotaDto.getFechaNacimiento() : null;
		Mascota mascota = new Mascota(null, nombreMascota, sexoMascota, razaMascota, tamanio, colorPredominante, colorSecundario, nroChipMascota, nroBeaconMascota, propietario, fechaNacimiento, null, null);		
		mascotaDao.persist(mascota);		
		
		List<String> imagenesParametro = mascotaDto.getImagenes();
		List<Imagen> imagenes = new ArrayList<>();
		if (imagenesParametro != null && imagenesParametro.size() > 0) {
			for (String string : imagenesParametro) {
				if (StringUtils.isNotBlank(string)) {			
					Imagen imagen = new Imagen(null, null, mascota, string);				
					imagenes.add(imagen);
				}			
			}			
		}
		
		if (imagenes.size() > 0) {
			mascota.setImagenes(imagenes);
			mascotaDao.edit(mascota);
		}
		mascotaDto.setId(mascota.getId());
		return Response.ok().status(Response.Status.ACCEPTED).entity(mascotaDto).build();
	}
	
	public static String encoder(String imagePath) {
		String base64Image = "";
		File file = new File(imagePath);
		try (FileInputStream imageInFile = new FileInputStream(file)) {
			// Reading a Image file from file system
			byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		return base64Image;
	}
	
	public static void decoder(String base64Image, String pathFile) {
		try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
			// Converting a Base64 String into Image byte array
			byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
			imageOutFile.write(imageByteArray);
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
	}
	

	@Override
	public Response modificarMascota(MascotaDto mascotaDto) throws SeguridadChequeoException, PrivilegiosChequeoException {
		Mascota mascota = null;
		if (mascotaDto.getId() == null) 
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_REQUERIDO, "id de la mascota")).build();
		
		mascota = mascotaDao.find(mascotaDto.getId());		
		if (mascota != null) {	
			
			String nombre = mascotaDto.getNombre();
			String nombreMascota = nombre !=null ? nombre : "";
			
			String sexo = mascotaDto.getSexo();
			if (StringUtils.isBlank(sexo))
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_REQUERIDO, "sexo de la mascota")).build();
			List<SexoMascota> sexosDeMascota = sexoMascotaDao.findByAttribute(sexo, "descripcion");
			if (sexosDeMascota == null || sexosDeMascota.size() < 1)
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.SEXO_INCORRECTO, "sexo de la mascota")).build();
			SexoMascota sexoMascota = sexosDeMascota.get(0);
			
			String nroChip = mascotaDto.getNroChip();
			if (StringUtils.isNotBlank(nroChip)) {
				List<Mascota> mascotasPorNroChip = mascotaDao.findByAttribute(nroChip, "nroChip");
				if (mascotasPorNroChip != null && mascotasPorNroChip.size() > 0 && !mascota.getNroChip().equalsIgnoreCase(mascotaDto.getNroChip()))
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.MASCOTA_CON_NRO_CHIP_EXISTENTE)).build();
			}
			String nroChipMascota  = nroChip;
			
			String nroBeacon = mascotaDto.getNroBeacon();
			if (StringUtils.isNotBlank(nroBeacon)) {
				List<Mascota> mascotasPorNroBeacon = mascotaDao.findByAttribute(nroBeacon, "nroBeacon");
				if (mascotasPorNroBeacon != null && mascotasPorNroBeacon.size() > 0 && !mascota.getNroBeacon().equalsIgnoreCase(mascotaDto.getNroBeacon()))
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.MASCOTA_CON_NRO_BEACON_EXISTENTE)).build();
			}
			String nroBeaconMascota = nroBeacon !=null ? nroBeacon : "";
			
			Usuario propietario = null;
			String eMailPropietario = mascotaDto.getPropietario();
			if (StringUtils.isBlank(eMailPropietario)) 
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_REQUERIDO, "eMail del propietario")).build();
			List<Usuario> usuariosPorMail = usuarioDao.findByAttribute(eMailPropietario, "eMail");
			if (usuariosPorMail == null || usuariosPorMail.size() < 1)
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PROPIETARIO_INEXISTENTE)).build();
			propietario = usuariosPorMail.get(0);
			
			TipoMascota tipo = null;
			String tipoMascota = mascotaDto.getTipo();		
			if (StringUtils.isNotBlank(tipoMascota)) {
				List<TipoMascota> tiposDeMascotas = tipoMascotaDao.findByAttribute(tipoMascota, "descripcion");
				if (tiposDeMascotas != null && tiposDeMascotas.size() > 0) {
					for (TipoMascota tipoM : tiposDeMascotas) {
						if (tipoM.getDescripcion().equalsIgnoreCase(tipoMascota))
							tipo = tipoM;
					}		
					if (tipo == null)
						return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.TIPO_DE_MASCOTA_INEXISTENTE)).build();
				}
				else
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.TIPOS_DE_MASCOTAS_INEXISTENTES)).build();
			}
			else 
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_REQUERIDO, "tipo de mascota")).build();
			
			Raza razaMascota = null;
			List<Raza> razasMascotas = razaDao.obtenerRazasPorTipoDeMascota(tipo.getDescripcion());
			if (razasMascotas == null || razasMascotas.size() < 1)
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.RAZA_INEXISTENTE)).build();
			for (Raza raza : razasMascotas) {
				if (raza.getDescripcion().equalsIgnoreCase(mascotaDto.getRaza()))
					razaMascota = raza;
			}
			if (razaMascota == null)
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.RAZA_INEXISTENTE)).build();
			
			Tamanio tamanio = null;
			String tamanioMascota = mascotaDto.getTamanio();	
			if (StringUtils.isNotBlank(tamanioMascota)) {
				List<Tamanio> tamaniosDeMascotas = tamanioMascotaDao.findByAttribute(tamanioMascota, "descripcion");
				if (tamaniosDeMascotas == null || tamaniosDeMascotas.size() < 1)
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.TAMANIO_DE_MASCOTA_INEXISTENTE)).build();
				tamanio = tamaniosDeMascotas.get(0);
			}
			else 
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_REQUERIDO, "tamaño de mascota")).build();
			
			
			Color colorPredominante =  null;
			Color colorSecundario =  null;
			String colorPredominanteMascota = mascotaDto.getColorPredominante();	
			String colorSecundarioMascota = mascotaDto.getColorSecundario();	
			if (StringUtils.isNotBlank(colorPredominanteMascota) || StringUtils.isNotBlank(colorSecundarioMascota)) {
				List<Color> coloresPredominantesDeMascotas = colorMascotaDao.obtenerColorPorTipoYDescripcion("P", colorPredominanteMascota);
				List<Color> coloresSecundariosDeMascotas = colorMascotaDao.obtenerColorPorTipoYDescripcion("S", colorSecundarioMascota);
				if (coloresPredominantesDeMascotas == null || coloresPredominantesDeMascotas.size() < 1 || coloresSecundariosDeMascotas == null || coloresSecundariosDeMascotas.size() < 1)
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.COLORES_MASCOTAS_INVALIDOS).build();
				colorPredominante = coloresPredominantesDeMascotas.get(0);
				colorSecundario = coloresSecundariosDeMascotas.get(0);
			}
			else
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETROS_REQUERIDOS, "colores de la mascota")).build();
			
			Date fechaNacimiento = mascotaDto.getFechaNacimiento() != null ? mascotaDto.getFechaNacimiento() : null;
			
			List<String> imagenesParametro = mascotaDto.getImagenes();
			List<Imagen> imagenes = new ArrayList<>();
			if (imagenesParametro != null && imagenesParametro.size() > 0) {
				for (String string : imagenesParametro) {
					if (StringUtils.isNotBlank(string)) {			
						Imagen imagen = new Imagen(null, null, mascota, string);				
						imagenes.add(imagen);
					}			
				}
			}			
			
			mascota.setColorPredominante(colorPredominante);
			mascota.setColorSecundario(colorSecundario);
			mascota.setFechaNacimiento(fechaNacimiento);
			mascota.setImagenes(imagenes);
			mascota.setNombre(nombreMascota);
			mascota.setNroBeacon(nroBeaconMascota);
			mascota.setNroChip(nroChipMascota);
			mascota.setPropietario(propietario);
			mascota.setSexo(sexoMascota);
			mascota.setTamanio(tamanio);
			mascota.setRaza(razaMascota);
			mascotaDao.edit(mascota);
			return Response.ok().status(Response.Status.ACCEPTED).entity(mascotaDto).build(); 
		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.MASCOTA_INEXISTENTE).build();
	}

	@Override
	public Response eliminarMascota(Long id) throws SeguridadChequeoException, PrivilegiosChequeoException{
		Mascota mascotaBuscada = null;
		if (id != null) {
			mascotaBuscada = mascotaDao.find(id);
			if (mascotaBuscada == null)
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.MASCOTA_INEXISTENTE).build();
			Long idMascota = mascotaBuscada.getId();
			String nombreUsuario = mascotaBuscada.getPropietario().getNombreUsuario();
			List <BPMMascota> mascotasEnBPM = bpmMascotaDao.obtenerMascotasDeBPM(idMascota);
			if (mascotasEnBPM.size() > 0) {
				for (BPMMascota bpmMascota : mascotasEnBPM) {
					if (bpmMascota.getFechaHasta() == null)
						bpmMascotaDao.remove(bpmMascota);
					else {
						bpmMascota.setDescripcion(String.format(Constantes.MASCOTA_ELIMINADA_DEL_SISTEMA, bpmMascota.getMascota().getId()) );
						bpmMascota.setMascota(null);
						bpmMascota.setFechaHasta(new Date());
						bpmMascotaDao.edit(bpmMascota);
					}
				}
			}
			
			List<HistoriaClinica> historiasClinicas = historiaClinicaDao.obtenerHistoriaClinicaDeMascota(idMascota);
			if (historiasClinicas.size() > 0) {
				for (HistoriaClinica historia : historiasClinicas) {
					historiaClinicaDao.remove(historia);
				}
			}
			
			mascotaDao.remove(mascotaBuscada);
			List<Mascota> mascotas = mascotaDao.obtenerMascotaPorNombreUsuario(nombreUsuario);
			List<MascotaDto> mascotasDto = new ArrayList<>();
			MascotaDto mascotaDto = null;
			for (Mascota mascota : mascotas) {
				SexoMascota sexo = mascota.getSexo();
				Raza raza = mascota.getRaza();
				TipoMascota tipoMascota = raza.getTipoMascota();
				Tamanio tamanio = mascota.getTamanio();
				Color colorPredominante = mascota.getColorPredominante();
				Color colorSecundario = mascota.getColorSecundario();
				Usuario propietario = mascota.getPropietario();			
				String estadoUltimoMascota = bpmMascotaDao.obtenerUltimoEstadoDeMascotaPorIdMascota(mascota.getId());
				List<String> imagenesString = obtenerStringDeImagenes(mascota);
				
				mascotaDto = new MascotaDto(mascota.getId(), mascota.getNombre(), sexo != null ? sexo.getDescripcion() : null, raza != null && tipoMascota != null ? tipoMascota.getDescripcion() : null, raza != null ? raza.getDescripcion() : null, tamanio != null ? tamanio.getDescripcion() : null, colorPredominante != null ? colorPredominante.getDescripcion() : null, colorSecundario != null ? colorSecundario.getDescripcion() : null, mascota.getNroChip(), mascota.getNroBeacon(), propietario != null ? propietario.geteMail() : null, mascota.getFechaNacimiento(), null, imagenesString, estadoUltimoMascota);
				mascotasDto.add(mascotaDto);
			}
			return Response.ok().status(Response.Status.ACCEPTED).entity(mascotasDto).build();
		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.ERROR_AL_ELIMINAR_MASCOTA).build();
	}

	@Override
	public Response obtenerMascotas(Integer numeroDePagina, Integer cantidadPorPagina) throws SeguridadChequeoException, PrivilegiosChequeoException{
		List<Mascota> todasLasMascotasPaginado = mascotaDao.findAll(numeroDePagina, cantidadPorPagina);
		List <MascotaDto> mascotas = new ArrayList<>();
		if (todasLasMascotasPaginado != null && todasLasMascotasPaginado.size() > 0) {
			MascotaDto mascotaDto = null;
			Long cantidadRegistros = mascotaDao.totalCountFindAll();
			for (Mascota mascota : todasLasMascotasPaginado) {
				SexoMascota sexo = mascota.getSexo();
				Raza raza = mascota.getRaza();
				TipoMascota tipoMascota = raza.getTipoMascota();
				Tamanio tamanio = mascota.getTamanio();
				Color colorPredominante = mascota.getColorPredominante();
				Color colorSecundario = mascota.getColorSecundario();
				Usuario propietario = mascota.getPropietario();
				String estadoUltimoMascota = bpmMascotaDao.obtenerUltimoEstadoDeMascotaPorIdMascota(mascota.getId());
				List<String> imagenesString = obtenerStringDeImagenes(mascota);
				
				mascotaDto = new MascotaDto(mascota.getId(), mascota.getNombre(), sexo != null ? sexo.getDescripcion() : null, raza != null && tipoMascota != null ? tipoMascota.getDescripcion() : null, raza != null ? raza.getDescripcion() : null, tamanio != null ? tamanio.getDescripcion() : null, colorPredominante != null ? colorPredominante.getDescripcion() : null, colorSecundario != null ? colorSecundario.getDescripcion() : null, mascota.getNroChip(), mascota.getNroBeacon(), propietario != null ? propietario.geteMail() : null, mascota.getFechaNacimiento(), cantidadRegistros, imagenesString, estadoUltimoMascota);
				mascotas.add(mascotaDto);
			}
			
		}
		return Response.ok().status(Response.Status.ACCEPTED).entity(mascotas).build();
	}

	
	@Override
	public Response denunciarMascotaPerdida(MascotaPerdidaDto mascotaDto) throws SeguridadChequeoException, PrivilegiosChequeoException{
		Long idMascota = mascotaDto.getId();
		if (idMascota == null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_REQUERIDO, "id de mascota")).build();
		Mascota mascota = mascotaDao.find(idMascota);
		if (mascota == null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.MASCOTA_INEXISTENTE).build();
		
//		List<String> imagenes = mascotaDto.getImagenes();
//		if (imagenes == null || imagenes.size() < 1)
//			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_REQUERIDO, "imagen de la mascota")).build();
		
		List<Usuario> usuarios = usuarioDao.findByAttribute(mascotaDto.getPropietario(), "eMail");
		if (usuarios ==null || usuarios.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_INEXISTENTE).build();
		
		BPMMascota entity = new BPMMascota();
		List<ActividadMascota> actividadesMascota = actividadMascotaDao.findByAttribute("EXTRAVIADA", "descripcion");
		if (actividadesMascota == null || actividadesMascota.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_INCORRECTO, "actividad de la mascota")).build();		
		ActividadMascota actividadMascota = actividadesMascota.get(0);		
		Long idActividad = actividadMascota.getId();
		if (idActividad == null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.ERROR_ID_INVALIDO).build();
		entity.setActividad(actividadMascota);
		
		String nombreLocalidad = mascotaDto.getLocalidad();
		List<Localidad> localidades = localidadDao.findByAttribute(nombreLocalidad, "descripcion");
		Localidad localidad = null;
		if (localidades != null && localidades.size() > 0)
			localidad = localidades.get(0);
		
		List<CaracteristicaEspecial> caracteristicasEspeciales = new ArrayList<>();
		//Carcteristicas especiales
		List<String> caracteristicas = mascotaDto.getCaracteristicas();
		if (caracteristicas != null && caracteristicas.size() > 0) {
			for (String caracteristica : caracteristicas) {
				if (StringUtils.isNotBlank(caracteristica)) {
					List<CaracteristicaEspecial> caracteristaEspeciales = caracteristaEspecialDao.findByAttribute(caracteristica, "nombre");
					if (caracteristaEspeciales == null || caracteristaEspeciales.size() < 1)
						return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.CARACTERISTICA_ESPECIAL_INCORRECTA_DETALLADA, caracteristica)).build();
					else {
						caracteristicasEspeciales.add(caracteristaEspeciales.get(0));
					}
				}
			}			
		}
		
		Date fechaDesde = new Date();
		entity.setDescripcion(null);
		entity.setFechaDesde(fechaDesde);
		entity.setFechaHasta(null);
		entity.setLatitud(mascotaDto.getLatitud());
		entity.setLongitud(mascotaDto.getLongitud());
		entity.setMascota(mascota);
		entity.setUsuario(usuarios.get(0));	
		entity.setLocalidad(localidad);
		
		List<CaracteristicaEspecialTemporal> caracteristicasEspecialesTemporales = new ArrayList<>();
		CaracteristicaEspecialTemporal caracteristicaEspecialTemporal = null; 
		for (CaracteristicaEspecial caracteristicaEspecial : caracteristicasEspeciales) {
			caracteristicaEspecialTemporal = new CaracteristicaEspecialTemporal(null, caracteristicaEspecial);
			caracteristicasEspecialesTemporales.add(caracteristicaEspecialTemporal);
		}
		entity.setCaracteristicasEspeciales(caracteristicasEspecialesTemporales);
		
		if (existeMascotaEnActividad(idMascota, idActividad, fechaDesde)) {
			List<BPMMascota> periodosAbiertos = bpmMascotaDao.cerrarPeriodoAbiertoParaMascotaEnActividad(idMascota, idActividad);
			for (BPMMascota bpmMascota : periodosAbiertos) {
				bpmMascota.setFechaHasta(fechaDesde);
				bpmMascotaDao.edit(bpmMascota);
			}
		}
		
		bpmMascotaDao.persist(entity);	
		PublicarMascotaPerdidaDto publicarMascotaPerdidaDto = new PublicarMascotaPerdidaDto(RuffoConfig.TOKEN_FACEBOOK, mascota, localidad, caracteristicasEspeciales, caracteristicasEspecialesTemporales);
		encolardorMensajes.encolarMensaje(publicarMascotaPerdidaDto);
				
		return Response.ok().status(Response.Status.ACCEPTED).entity(MensajesValidacion.OPERACION_EXITOSA).build();
	}

	private boolean existeMascotaEnActividad(Long idMascota, Long idActividad, Date fechaDesde) {
		Long idMascotaEncontrada = bpmMascotaDao.existeMascotaEnActividad(idMascota, idActividad, fechaDesde);
		return idMascotaEncontrada != null;
	}

	@Override
	public Response obtenerMascotasPorEstado(Integer idEstado, Integer nroPagina, Integer cantPorPagina) {
		// TODO Se debe crear un BPM donde al denunciar una mascota como extraviada se guarda 
		// el id de mascota, en la actividad EXTRAVIADO, id persona denunciante, fecha de inicio, fecha de fin
		//Luego se hace una busqueda por estados
		return null;
	}

	@Override
	public Response obtenerMascotaPorId(Long id) throws SeguridadChequeoException, PrivilegiosChequeoException{
		Mascota mascota = null;
		if (id != null) {
			mascota = mascotaDao.find(id);
			if (mascota != null) {
				SexoMascota sexo = mascota.getSexo();
				Raza raza = mascota.getRaza();
				TipoMascota tipoMascota = raza.getTipoMascota();
				Tamanio tamanio = mascota.getTamanio();
				Color colorPredominante = mascota.getColorPredominante();
				Color colorSecundario = mascota.getColorSecundario();
				Usuario propietario = mascota.getPropietario();
				String estadoUltimoMascota = bpmMascotaDao.obtenerUltimoEstadoDeMascotaPorIdMascota(mascota.getId());
				List<String> imagenesString = obtenerStringDeImagenes(mascota);
				
				MascotaDto mascotaDto = new MascotaDto(mascota.getId(), mascota.getNombre(), sexo != null ? sexo.getDescripcion() : null, raza != null && tipoMascota != null ? tipoMascota.getDescripcion() : null, raza != null ? raza.getDescripcion() : null, tamanio != null ? tamanio.getDescripcion() : null, colorPredominante != null ? colorPredominante.getDescripcion() : null, colorSecundario != null ? colorSecundario.getDescripcion() : null, mascota.getNroChip(), mascota.getNroBeacon(), propietario != null ? propietario.geteMail() : null, mascota.getFechaNacimiento(), 1L, imagenesString, estadoUltimoMascota);
				return Response.ok().status(Response.Status.ACCEPTED).entity(mascotaDto).build();
			}
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.MASCOTA_INEXISTENTE).build();
			
		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.ERROR_AL_OBTENER_MASCOTA).build();
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
	public Response obtenerMascotaPorNombreUsuario(String nombreUsuario) {
		if (StringUtils.isBlank(nombreUsuario))
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_REQUERIDO, "mail del usuario")).build();
		List<Usuario> usuariosPorNombre = usuarioDao.findByAttribute(nombreUsuario, "nombreUsuario");
		if (usuariosPorNombre == null || usuariosPorNombre.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_INEXISTENTE).build();
		
		List<Mascota> todasLasMascotasPaginado = mascotaDao.obtenerMascotaPorNombreUsuario(nombreUsuario);
		List <MascotaDto> mascotas = new ArrayList<>();
		if (todasLasMascotasPaginado != null && todasLasMascotasPaginado.size() > 0) {
			MascotaDto mascotaDto = null;
			Long cantidadRegistros = mascotaDao.totalCountFindAll();
			for (Mascota mascota : todasLasMascotasPaginado) {
				SexoMascota sexo = mascota.getSexo();
				Raza raza = mascota.getRaza();
				TipoMascota tipoMascota = raza.getTipoMascota();
				Tamanio tamanio = mascota.getTamanio();
				Color colorPredominante = mascota.getColorPredominante();
				Color colorSecundario = mascota.getColorSecundario();
				Usuario propietario = mascota.getPropietario();
				String estadoUltimoMascota = bpmMascotaDao.obtenerUltimoEstadoDeMascotaPorIdMascota(mascota.getId());
				List<String> imagenesString = obtenerStringDeImagenes(mascota);		
				mascotaDto = new MascotaDto(mascota.getId(), mascota.getNombre(), sexo != null ? sexo.getDescripcion() : null, raza != null && tipoMascota != null ? tipoMascota.getDescripcion() : null, raza != null ? raza.getDescripcion() : null, tamanio != null ? tamanio.getDescripcion() : null, colorPredominante != null ? colorPredominante.getDescripcion() : null, colorSecundario != null ? colorSecundario.getDescripcion() : null, mascota.getNroChip(), mascota.getNroBeacon(), propietario != null ? propietario.geteMail() : null, mascota.getFechaNacimiento(), cantidadRegistros, imagenesString, estadoUltimoMascota);
				mascotas.add(mascotaDto);
			}
			
		}
		return Response.ok().status(Response.Status.ACCEPTED).entity(mascotas).build();
	}

	@Override
	public Response validarSiMascotaPerdida(Long id) throws SeguridadChequeoException, PrivilegiosChequeoException{
		Mascota mascotaBuscada = null;
		if (id != null) {
			mascotaBuscada = mascotaDao.find(id);
			if (mascotaBuscada == null) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.MASCOTA_INEXISTENTE).build();
			}
			else {
				List <BPMMascota> mascotasEnBPM = bpmMascotaDao.obtenerMascotasDeBPM(mascotaBuscada.getId());
				if (mascotasEnBPM.size() > 0)
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.MASCOTA_SE_ENCUENTRA_PERDIDA).build();
				else 
					return eliminarMascota(id);
			}
		}
		else 
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_REQUERIDO, "id de mascota")).build();
	}

	@Override
	public Response obtenerMascotasPerdidasDeUsuario(String nombreUsuario) throws SeguridadChequeoException, PrivilegiosChequeoException {
		if (StringUtils.isBlank(nombreUsuario))
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format(MensajesValidacion.PARAMETRO_REQUERIDO, "nombre del usuario")).build();
		List<Usuario> usuarios = usuarioDao.findByAttribute(nombreUsuario, "nombreUsuario");
		
		if (usuarios == null || usuarios.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_INEXISTENTE).build();
		
		List<Mascota> mascotasPerdidasDeUsuario = bpmMascotaDao.obtenerMascotasDeBPMDeUsuario(usuarios.get(0).getId());
		List<MascotaDto> mascotasPerdidasDeUsuarioDto = null;

		if (mascotasPerdidasDeUsuario == null || mascotasPerdidasDeUsuario.size() < 1)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MensajesValidacion.USUARIO_NO_POSEE_MASCOTAS_PERDIDAS).build();
		
		mascotasPerdidasDeUsuarioDto = new ArrayList<>();
		MascotaDto mascotaDto = null;
		for (Mascota mascota : mascotasPerdidasDeUsuario) {
			Date fechaNacimiento = mascota.getFechaNacimiento();
			Long id = mascota.getId();
			String nombre = mascota.getNombre();
			String sexo = mascota.getSexo().getDescripcion();
			String tipo = mascota.getRaza().getTipoMascota().getDescripcion();
			String raza = mascota.getRaza().getDescripcion();
			String tamanio = mascota.getTamanio().getDescripcion();
			String colorPredominante = mascota.getColorPredominante().getDescripcion();
			String colorSecundario  = mascota.getColorSecundario().toString();
			String nroChip = mascota.getNroChip();
			String nroBeacon = mascota.getNroBeacon();
			String propietario  = mascota.getPropietario().getNombreUsuario();
			Long totalRegistros = new Long (mascotasPerdidasDeUsuario.size());
			List<Imagen> imagenes = mascota.getImagenes();
			List<String> imagenesString = new ArrayList<>();
			for (Imagen imagen : imagenes) {
				imagenesString.add(imagen.getImagen());
			}
			String estadoUltimoMascota = bpmMascotaDao.obtenerUltimoEstadoDeMascotaPorIdMascota(mascota.getId());
			mascotaDto = new MascotaDto(id, nombre, sexo, tipo, raza, tamanio, colorPredominante, colorSecundario, nroChip, nroBeacon, propietario, fechaNacimiento, totalRegistros, imagenesString, estadoUltimoMascota);
			mascotasPerdidasDeUsuarioDto.add(mascotaDto);
		}
		return Response.status(Response.Status.OK).entity(mascotasPerdidasDeUsuarioDto).build();
	}
}
