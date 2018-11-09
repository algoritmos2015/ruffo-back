package com.ruffo.utils;

import java.util.Date;

import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.ruffo.servicios.implementaciones.PersonaServiceImp;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Interceptor
@Service(validatorClass=ServiceValidator.class)
public class ServiceInterceptor {

	@Inject
    HttpServletRequest request;
	
	static Logger log4j = Logger.getLogger(PersonaServiceImp.class);
	
	@AroundInvoke
    public Object chequearSeguridad(InvocationContext context) throws Exception, SeguridadChequeoException, PrivilegiosChequeoException {
		String header = request.getHeader("Authorization");     
    	if (header == null) {
        	throw new SeguridadChequeoException();
        }
        try {
        	String token = header; 
        	String tokenActualizado = null; 
        	Jws<Claims> claims = Jwts.parser().setSigningKey(Constantes.KEY.getBytes("UTF-8")).parseClaimsJws(token);
        	Date expiration = claims.getBody().getExpiration();
        	//Se valida que la sesión esté activa
        	if (expiration.before(new Date())) {
        		throw new SeguridadChequeoException();       	
        	}
        	else {
        		DateTime fechaActual = DateTime.now();
    			Date fechaExpiracion = fechaActual.plusMinutes(60).toDate();        		
        		tokenActualizado = Jwts.builder()
						  .setSubject(claims.getBody().getSubject())
						  .setAudience(claims.getBody().getAudience())
						  .setIssuedAt(claims.getBody().getIssuedAt())
						  .setExpiration(fechaExpiracion)
						  .claim("roles", claims.getBody().get("roles")) 
						  .signWith(SignatureAlgorithm.HS256, Constantes.KEY.getBytes("UTF-8")
						  ).compact();
        	}
        	
        	/*Se valida que el usuario tenga los roles necesarios para obtener el recurso deseado
        	 * Se deja comentado por alcance del proyecto. Pero la implementación está contemplada */
        	 
        	//ArrayList<String> object = (ArrayList<String>) claims.getBody().get("roles");        	
        	
            Service serviceAnnotationInstance = context.getMethod().getAnnotation(Service.class);
        	ServiceValidator validator = (ServiceValidator) CDI.current().select(serviceAnnotationInstance.validatorClass()).get();
        	/*validator.validatarPrivilegios(object);
        	 * Si se desean validar los privilegios se debe descomentar esta línea*/
        	
        	/* Si todo está OK, se llama a proceed() para que llame al método original */
            Object ret = context.proceed();
            /* realizar cualquier trabajo posterior a llamada de método */
            
            
            //TODO
            //Asignar al contexto el token actualizado 
            return ret;			
		} catch (io.jsonwebtoken.ExpiredJwtException e) {
			log4j.error(e.getMessage());
			throw new SeguridadChequeoException();       	
    	}         
        catch (io.jsonwebtoken.MalformedJwtException e2) {
        	log4j.error(e2.getMessage());
			throw new SeguridadChequeoException();     
        }
	}
}
