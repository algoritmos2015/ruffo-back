package com.ruffo.utils;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.commons.lang3.StringUtils;
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
public abstract class AbstractConfiguration {
	
	final static Logger logger = Logger.getLogger(AbstractConfiguration.class);
	
	
	/**
	 * Componente de manejo de archivos de properties.
	 */
	private  CompositeConfiguration config = null;
	

	/**
	 *
	 */
	protected AbstractConfiguration(String configFilename) {
		super();
		try {
			this.config = new CompositeConfiguration();
			this.config.addConfiguration(new SystemConfiguration());
			PropertiesConfiguration props = new PropertiesConfiguration();
			props.setEncoding("utf-8");
			logger.debug("Loading properties with utf-8 encoding...");
			if (StringUtils.isBlank(configFilename)) {
				logger.error("No configuration filename has been provided for loading....");
				throw new RuntimeException("The configuration filename is required for loading!!!");
			}
			props.load(RuffoConfig.class.getClassLoader().getResource(configFilename));
			props.setThrowExceptionOnMissing(true);
			FileChangedReloadingStrategy strategy = new FileChangedReloadingStrategy();
			// Cada 5 minutos para evitar que se haga un acceso a disco cada vez que se pida una property para verificar si el archivo cambió.
			strategy.setRefreshDelay(300000);
			props.setReloadingStrategy(strategy);
			this.config.addConfiguration(props);
		} catch (ConfigurationException e) {
			logger.error("An error has occurred while reading the application properties file: ", e);
			throw new RuntimeException(e);
		}
	}


	/**
	 * @return the config
	 */
	protected CompositeConfiguration getConfig() {
		return config;
	}


	/**
	 * @param config the config to set
	 */
	protected void setConfig(CompositeConfiguration config) {
		this.config = config;
	}
	
}
