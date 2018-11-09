package com.ruffo.utils;

import java.util.Date;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.ruffo.servicios.implementaciones.PersonaServiceImp;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

@Interceptor
@com.ruffo.utils.SeguridadChequeo
public class SeguridadChequeoInterceptor {
	
	@Inject
    HttpServletRequest request;
	
	static Logger log4j = Logger.getLogger(PersonaServiceImp.class);
	
    @AroundInvoke
    public Object chequearSeguridad(InvocationContext context) throws Exception, SeguridadChequeoException, PrivilegiosChequeoException {   	
    	String header = request.getHeader("Authorization");
    	String name = context.getTarget().toString();
    	Object[] parameters = context.getParameters();
//    	List<String> roles = (List<String>) parameters[0];
//    	for (String string : roles) {
//			System.out.println(string);
//		}
        if (header == null) {
        	throw new SeguridadChequeoException();
        }
        try {
        	String token = header;        
        	Jws<Claims> claims = Jwts.parser().setSigningKey(Constantes.KEY.getBytes("UTF-8")).parseClaimsJws(token);
        	Date expiration = claims.getBody().getExpiration();
        	/* Se comenta por si se desea utilizar en el futuro */
//        	String subject = claims.getBody().getSubject(); 
//        	String audience = claims.getBody().getAudience();
//        	Date issuedAt = claims.getBody().getIssuedAt();
//        	String roles = claims.getBody().get("roles").toString(); Si se desean obtener los roles        	
        	
        	/* si la validación de seguridad falla, puede generar una excepción. Tambiés se deja PrivilegiosChequeoException para chequear privilegios por operación en un futuro */
        	if (expiration.before(new Date())) {
        		throw new SeguridadChequeoException();       	
        	}
        	
        	/* invocar el método proceed() para que llame al método original */
            Object ret = context.proceed();

            /* realizar cualquier trabajo posterior a llamada de método */
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