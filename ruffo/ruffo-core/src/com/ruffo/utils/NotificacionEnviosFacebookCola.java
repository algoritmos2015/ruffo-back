package com.ruffo.utils;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.log4j.Logger;

import com.ruffo.dto.PublicarMascotaPerdidaDto;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/queue/facebookQueue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") }, mappedName = "java:/queue/facebookQueue")
public class NotificacionEnviosFacebookCola implements MessageListener {

		@Inject
		PublicadorRedesSociales publicadorRedesSociales;

		static Logger log4j = Logger.getLogger(NotificacionEnviosFacebookCola.class);

		public NotificacionEnviosFacebookCola() {
		}

		@Override
		public void onMessage(Message message) {			
			try {
				ObjectMessage objectMessage = (ObjectMessage) message;
				if (objectMessage.getObject().getClass().getName().equalsIgnoreCase(PublicarMascotaPerdidaDto.class.getName())) {
					PublicarMascotaPerdidaDto publicarMascotaPerdidaEnFacebookDto = (PublicarMascotaPerdidaDto) objectMessage.getObject();
					publicadorRedesSociales.publicarMascotaPerdidaEnFacebook(publicarMascotaPerdidaEnFacebookDto);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}


