package com.ruffo.utils;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/queue/mailQueue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") }, mappedName = "java:/queue/mailQueue")
public class NotificacionEnviosCola implements MessageListener {

	@Inject
	EnviadorDeMails envioaorDeMails;

	static Logger log4j = Logger.getLogger(NotificacionEnviosCola.class);

	public NotificacionEnviosCola() {
	}

	@Override
	public void onMessage(Message message) {
		try {
			TextMessage msg = (TextMessage) message;
			int posDelCaracterEspecialTipoMensaje = msg.getText().indexOf(Constantes.MAIL_CARACTER_EXPECIAL_TIPO_MAIL);
			int posDelCaracterEspecial = msg.getText().indexOf(Constantes.MAIL_CARACTER_EXPECIAL_DESTINATARIO_MAIL);
			String tipoMail = msg.getText().substring(0, posDelCaracterEspecialTipoMensaje);
			String destinatario = msg.getText().substring(posDelCaracterEspecialTipoMensaje + 2, posDelCaracterEspecial);
			if (tipoMail.equalsIgnoreCase(Constantes.MAIL_TIPO_CONFIRMACION_CUENTA.toString())) {
				String codigoConfirmacion = msg.getText().substring(posDelCaracterEspecial + 2, msg.getText().length());
				envioaorDeMails.enviarMailConfirmacionCuenta(destinatario, codigoConfirmacion);				
			}
			
			if (tipoMail.equalsIgnoreCase(Constantes.MAIL_TIPO_MASCOTA_ENCONTRADA.toString())) {
				int posDelCaracterEspecialMascotaId = msg.getText().indexOf(Constantes.MAIL_CARACTER_EXPECIAL_MASCOTA_ID);
				String mascotaId = msg.getText().substring(posDelCaracterEspecial + 2, posDelCaracterEspecialMascotaId);
				String usuarioQueEncontroId = msg.getText().substring(posDelCaracterEspecialMascotaId + 2, msg.getText().length());
				envioaorDeMails.enviarMailMascotaEncontrada(destinatario, mascotaId, usuarioQueEncontroId);
			}
			
			if (tipoMail.equalsIgnoreCase(Constantes.MAIL_TIPO_REENVIO_CLAVE.toString())) {
				int posDelCaracterEspecialMascotaId = msg.getText().indexOf(Constantes.MAIL_CARACTER_EXPECIAL_NUEVA_CLAVE);
				String clave = msg.getText().substring(posDelCaracterEspecial + 2, msg.getText().length());
				envioaorDeMails.enviarMailReenvioDeClave(destinatario, clave);
			}
		
		} catch (JMSException ex) {
			log4j.fatal(ex.getMessage());
		}

	}

}
