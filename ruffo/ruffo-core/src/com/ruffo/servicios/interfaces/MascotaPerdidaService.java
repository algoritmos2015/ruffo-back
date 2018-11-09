package com.ruffo.servicios.interfaces;

import javax.ws.rs.core.Response;

import com.ruffo.dto.BusquedaBeaconParametroDto;
import com.ruffo.dto.CaracteristicaEspecialDto;
import com.ruffo.dto.MascotaPerdidaDto;
import com.ruffo.utils.PrivilegiosChequeoException;
import com.ruffo.utils.SeguridadChequeoException;

public interface MascotaPerdidaService {

	Response agregarMascotaAjenaEncontrada(MascotaPerdidaDto mascotaDto) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response agregarCaracteristicaEspecial(CaracteristicaEspecialDto caracteristicaEspecialDto) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response modificarCaracteristicaEspecial(CaracteristicaEspecialDto caracteristicaEspecialDto) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response buscarMascotaPerdidaEnBPM(MascotaPerdidaDto mascotaPerdidaDto) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response buscarMascotaPerdidaEnMascotasPerdidas(MascotaPerdidaDto mascotaPerdidaDto) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response pasarMascotaAEstadoEncontrado(Long idMascotaPerdida, Long idMascota) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response obtenerMascotasEncontradasDeUsuario(String nombreUsuario) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response realizarLecturaDeNroChipNroBeacon(BusquedaBeaconParametroDto busquedaBeaconParametroDto) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response desactivarBusquedaDeMascota(Long idMascotaPerdida) throws SeguridadChequeoException, PrivilegiosChequeoException;

	Response desactivarBusquedaDeMascotaPorObjeto(MascotaPerdidaDto mascotaPerdidaDto)throws SeguridadChequeoException, PrivilegiosChequeoException;

}