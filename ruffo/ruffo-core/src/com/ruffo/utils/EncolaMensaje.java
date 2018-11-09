package com.ruffo.utils;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.ws.rs.core.Response;

import com.ruffo.dto.EnvioMailMascotaEncontradaDto;
import com.ruffo.dto.EnvioMailMascotaEncontradaPropiaDto;
import com.ruffo.dto.PublicarMascotaPerdidaDto;
import com.ruffo.mensajes.MensajesValidacion;

/**
 *
 * @author Gonzalo
 */

public class EncolaMensaje {
    @Resource(mappedName = "java:/JmsXA")
    private ConnectionFactory cf;

    @Resource(mappedName = "java:/queue/mailQueue")
    private Queue queue;
    
    @Resource(mappedName = "java:/queue/objetoQueue")
    private Queue objetoQueue;
    
    @Resource(mappedName = "java:/queue/facebookQueue")
    private Queue facebookQueue;
    
    public Response encolarMensaje(String mensaje) {
        try {
            Connection connection = cf.createConnection();
            Session session = connection.createSession();
            TextMessage msg = session.createTextMessage(mensaje);
            MessageProducer producer = session.createProducer(queue);
            producer.send(msg);
            session.close();
            connection.close();
            return Response.ok().status(Response.Status.ACCEPTED).entity(MensajesValidacion.OPERACION_EXITOSA).build();
        } catch (JMSException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.toString()).build();
        }        
    }

	public Response encolarMensaje(EnvioMailMascotaEncontradaDto envioMailMascotaEncontradaDto) {
		try {
            Connection connection = cf.createConnection();
            Session session = connection.createSession();
            MessageProducer producer = session.createProducer(objetoQueue);            
            ObjectMessage objMessage = session.createObjectMessage();
    		objMessage.setObject(envioMailMascotaEncontradaDto);
            producer.send( objMessage );
            session.close();
            connection.close();   
            return Response.ok().status(Response.Status.ACCEPTED).entity(MensajesValidacion.OPERACION_EXITOSA).build();
        } catch (JMSException ex) {
        	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.toString()).build();
        }		
	}

	public Response encolarMensaje(EnvioMailMascotaEncontradaPropiaDto envioMailMascotaEncontradaPropiaDto) {
		try {
            Connection connection = cf.createConnection();
            Session session = connection.createSession();
            MessageProducer producer = session.createProducer(objetoQueue);            
            ObjectMessage objMessage = session.createObjectMessage();
    		objMessage.setObject(envioMailMascotaEncontradaPropiaDto);
            producer.send( objMessage );
            session.close();
            connection.close();   
            return Response.ok().status(Response.Status.ACCEPTED).entity(MensajesValidacion.OPERACION_EXITOSA).build();
        } catch (JMSException ex) {
        	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.toString()).build();
        }			
	}

	public Response encolarMensaje(PublicarMascotaPerdidaDto publicarMascotaPerdidaDto) {
		try {
            Connection connection = cf.createConnection();
            Session session = connection.createSession();
            MessageProducer producer = session.createProducer(facebookQueue);            
            ObjectMessage objMessage = session.createObjectMessage();
    		objMessage.setObject(publicarMascotaPerdidaDto);
            producer.send( objMessage );
            session.close();
            connection.close();   
            return Response.ok().status(Response.Status.ACCEPTED).entity(MensajesValidacion.OPERACION_EXITOSA).build();
        } catch (JMSException ex) {
        	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.toString()).build();
        }		
	}
}