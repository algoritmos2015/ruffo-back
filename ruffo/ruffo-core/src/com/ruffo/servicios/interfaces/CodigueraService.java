package com.ruffo.servicios.interfaces;

import javax.ws.rs.core.Response;

public interface CodigueraService {
	
	Response obtenerColorPorTipo(String tipoColor);

	Response obtenerTiposDeMascotas();

	Response obtenerSexosDeMascotas();

	Response obtenerRazasDeMascotas(String tipoMascota);

	Response obtenerCaracteristicasEspecialesDeMascotas(Integer nroPagina, Integer cantPorPagina);

	Response obtenerCaracteristicasEspecialesDeMascotasPorParte(String parte);

	Response obtenerRazasDeMascotasAutocompletar(String tipoMascota, String texto);

	Response obtenerDeparamentos();

	Response obtenerDeparamentosPorPais(Long idPais, Integer nroPagina, Integer cantPorPagina);

	Response obtenerLocalidadesDeDeparamentos(Long idDepartamento, Integer nroPagina, Integer cantPorPagina);
}
