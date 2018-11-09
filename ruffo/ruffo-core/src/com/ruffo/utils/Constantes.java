package com.ruffo.utils;

public class Constantes {
	public static final String FORMATO_FECHA = "yyyy-MM-dd HH:mm";
	public static final int TAMANIO_MAX_VARCHAR_MYSQL = 255;
	public static final String KEY = "Ruffo.2017.Key";

	//Tipos de emails
	public static final Long MAIL_TIPO_CONFIRMACION_CUENTA = 1L;
	public static final Long MAIL_TIPO_MASCOTA_ENCONTRADA = 2L;
	public static final Long MAIL_TIPO_REENVIO_CLAVE = 3L;
	
	//Caracteres especiales emails
	public static final String MAIL_CARACTER_EXPECIAL_TIPO_MAIL = ";¡";
	public static final String MAIL_CARACTER_EXPECIAL_DESTINATARIO_MAIL = ";!";
	public static final String MAIL_CARACTER_EXPECIAL_MASCOTA_ID = ";?";
	public static final String MAIL_CARACTER_EXPECIAL_USUARIO_QUE_ENCONTRO_ID = ";¿";
	public static final String MAIL_CARACTER_EXPECIAL_NUEVA_CLAVE = ";=";
	
	public static final String ACT_AUTOMATICA_ENCONTRADA = "ACT-AUTOMATICA: MASCOTA ENCONTRADA";
	public static final String ACT_AUTOMATICA_ENCONTRADA_OTRO_MEDIO = "ACT-AUTOMATICA: MASCOTA ENCONTRADA POR OTRO MEDIO";
	public static final String MASCOTA_ELIMINADA_DEL_SISTEMA = "ACT-AUTOMATICA: MASCOTA %s ELIMINADA";
	public static final String MASCOTA_PERDIDA_ELIMINADA_DEL_SISTEMA = "ACT-AUTOMATICA: MASCOTA PERDIDA %s ELIMINADA";
}
