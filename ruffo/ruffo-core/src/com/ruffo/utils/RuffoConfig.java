package com.ruffo.utils;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.log4j.Logger;

/**
 * Componente para obtener valores configurables del sistema. Estos valores son
 * centralizados en un archivo externo a la aplicación que podrá ser modificado
 * en tiempo de ejecución.
 *
 * <b>El refesco de estas propiedades va a ser cada 5 minutos</b>. Es decir, si se
 * modifica este archivo deberá esperarse hasta un máximo de 5 minutos (pudiendo
 * ser menos) desde que se modifica para que el cambio se haga efectivo.
 *
 */
public final class RuffoConfig extends AbstractConfiguration {

	final static Logger logger = Logger.getLogger(RuffoConfig.class);

	/**
	 * Instancia singleton de componente GIS de configuración.
	 */
	private static RuffoConfig instance = null;
	
	private static final String RUFFO_CONFIG_PROPERTIES = "ruffo-config.properties";
	
	public static final String CONFIRMAR_CUENTA_FROM = "mail.confirmar.cuenta.from";
	
	public static final String CONFIRMAR_CUENTA_USERNAME = "mail.confirmar.cuenta.username";
	
	public static final String CONFIRMAR_CUENTA_PASS = "mail.confirmar.cuenta.pass";

	public static final String CONFIRMAR_CUENTA_IMAGEN = "mail.confirmar.cuenta.imagen";
	
	public static final String MASCOTA_ENCONTRADA_IMAGEN = "mail.mascota.encontrada.imagen";

	public static final String DIRECTORIO_IMAGENES_APLICACION_WINDOWS = "directorio.imagenes.aplicacion.windows";

	public static final String DIRECTORIO_IMAGENES_APLICACION_MAC = "directorio.imagenes.aplicacion.mac";

	public static final String DIRECTORIO_IMAGENES_APLICACION_UNIX = "directorio.imagenes.aplicacion.unix";

	public static final String CANTIDAD_LOGEOS_PERMITIDOS = "cantidad.logeos.permitidos";

	public static final String PATA_GENERICA_IMAGEN = "pata.generica.imagen";

	public static final String TOKEN_FACEBOOK = "token.facebook";

	
	/**
	 * @param configFilename
	 */
	private RuffoConfig() {
		super(RUFFO_CONFIG_PROPERTIES);
	}

	/**
	 *
	 * @return A singleton instance of this component.
	 */
	protected static RuffoConfig getInstance() {
		if (instance == null) {
			instance = new RuffoConfig();
		}
		return instance;
	}

	/**
	 * 
	 * @return The underlying apache configuration component in order to retrieve values.
	 */
	public static CompositeConfiguration getConfiguration() {
		return getInstance().getConfig();
	}
}
