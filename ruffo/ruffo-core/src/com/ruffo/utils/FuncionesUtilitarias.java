package com.ruffo.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

public class FuncionesUtilitarias {
	
	private static String SistemaOperativo = System.getProperty("os.name").toLowerCase();
	
	public static String NUMEROS = "0123456789";
 
	public static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
 
	public static String ESPECIALES = "Ò—";
 
	//
	public static String getPinNumber() {
		return getPassword(NUMEROS, 4);
	}
 
	public static String getPassword() {
		return getPassword(8);
	}
 
	public static String getPassword(int length) {
		return getPassword(NUMEROS + MINUSCULAS, length);
	}
 
	public static String getPassword(String key, int length) {
		String pswd = "";
 
		for (int i = 0; i < length; i++) {
			pswd+=(key.charAt((int)(Math.random() * key.length())));
		}
 
		return pswd;
	}
 
   
    public static boolean isWindows() {
        return (SistemaOperativo.indexOf("win") >= 0);
    }
 
    public static boolean isMac() {
        return (SistemaOperativo.indexOf("mac") >= 0);
    }
 
    public static boolean isUnix() {
        return (SistemaOperativo.indexOf("nix") >= 0 || SistemaOperativo.indexOf("nux") >= 0 || SistemaOperativo.indexOf("aix") > 0 );
    }
 
    public static boolean isSolaris() {
        return (SistemaOperativo.indexOf("sunos") >= 0);
    }
	public static boolean esMailFormatoCorrecto(String email){        
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"; 
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);        
        return matcher.matches();
    }
	
	public static boolean esClaveFormatoCorrecto(String clave) {
		return (StringUtils.isBlank(clave) || clave.length() < 6);			
	}
	
	public static String crearCodigoActivacion() {
		String milisegundos = new Integer (DateTime.now().getMillisOfDay()).toString();
		String codigoConfirmacion = StringUtils.substring(milisegundos, 0, 5);
		return codigoConfirmacion;
	}
	
    public static String encriptar(String s) throws UnsupportedEncodingException{
        return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
    }
    
    public static String desencriptar(String s) throws UnsupportedEncodingException{
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        return new String(decode, "utf-8");
    }
			
}
