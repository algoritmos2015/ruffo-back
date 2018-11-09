package com.ruffo.servicios.interfaces;

import javax.ws.rs.core.Response;

import com.ruffo.dto.UsuarioDto;
import com.ruffo.dto.UsuarioIniciarSesionDto;
import com.ruffo.utils.PrivilegiosChequeoException;
import com.ruffo.utils.SeguridadChequeoException;

public interface UsuarioService {

	Response agregarUsuario(UsuarioDto usuarioDTO) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response modificarUsuario(UsuarioDto usuarioDTO) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response eliminarUsuario(String nombreUsuario) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response obtenerUsuarios(Integer nroPagina, Integer cantPorPagina) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Boolean validarNombreUsuarioYClave(String nombre, String clave);

	Response iniciarSesion(UsuarioIniciarSesionDto usuarioValidacion);

	Response obtenerUsuarioPorId(Long id) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response obtenertiposDeUsuario();

	Response activarUsuario(String eMail, String codigoConfirmacion);

	Response reenviarCodigoActivacionUsuario(String eMail);

	Response cerrarSesion(String nombreUsuario);
	
	Response obtenerUsuarioPorNombre(String nombreUsuario) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response olvidoDeClave(String nombreUsuario);

	Response modificarClave(UsuarioIniciarSesionDto usuarioIniciarSesion);
}
