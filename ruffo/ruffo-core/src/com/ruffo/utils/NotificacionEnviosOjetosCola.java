package com.ruffo.utils;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.log4j.Logger;

import com.ruffo.dto.EnvioMailMascotaEncontradaDto;
import com.ruffo.dto.EnvioMailMascotaEncontradaPropiaDto;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/queue/objetoQueue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") }, mappedName = "java:/queue/objetoQueue")
public class NotificacionEnviosOjetosCola implements MessageListener {

	@Inject
	EnviadorDeMails envioaorDeMails;

	static Logger log4j = Logger.getLogger(NotificacionEnviosOjetosCola.class);

	public NotificacionEnviosOjetosCola() {
	}

	@Override
	public void onMessage(Message message) {			
		try {
			ObjectMessage objectMessage = (ObjectMessage) message;
			if (objectMessage.getObject().getClass().getName().equalsIgnoreCase(EnvioMailMascotaEncontradaDto.class.getName())) {
				EnvioMailMascotaEncontradaDto envioMailMascotaEncontradaDto = (EnvioMailMascotaEncontradaDto) objectMessage.getObject();
				String destinatario = envioMailMascotaEncontradaDto.getDestinatario();
				String nombreMascota = envioMailMascotaEncontradaDto.getNombreMascota();
				String mailUsuarioQueEncuentra = envioMailMascotaEncontradaDto.getMailUsuarioQueEncuentra();
				String telefono = envioMailMascotaEncontradaDto.getTelefonoDeContacto();
				envioaorDeMails.enviarMailMascotaEncontrada(destinatario, nombreMascota, mailUsuarioQueEncuentra, telefono);
			}
			if (objectMessage.getObject().getClass().getName().equalsIgnoreCase(EnvioMailMascotaEncontradaPropiaDto.class.getName())) {
				EnvioMailMascotaEncontradaPropiaDto envioMailMascotaEncontradaPropiaDto = (EnvioMailMascotaEncontradaPropiaDto) objectMessage.getObject();
				String destinatario = envioMailMascotaEncontradaPropiaDto.getDestinatario();
				envioaorDeMails.enviarMailMascotaEncontradaMascotaPerdida(destinatario, envioMailMascotaEncontradaPropiaDto.getTextoMail());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
