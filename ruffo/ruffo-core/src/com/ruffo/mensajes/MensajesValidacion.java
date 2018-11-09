package com.ruffo.mensajes;

import com.ruffo.utils.Constantes;

public class MensajesValidacion {
	
	public static final String PERSONA_CON_EMAIL_EXISTETE = "Persona con email ya registrado en el sistema";
	public static final String ERROR_AL_AGREGAR_PERSONA = "Ocurrio un errror al agregar la persona";
	public static final String NOMBRE_USUARIO_EXISTENTE = "Nombre de usuario existente. Por favor seleccione otro";
	public static final String NOMBRE_USUARIO_INCORRECTO = "Nombre de usuario incorrecto. No debe ser vacio ni superar los "+Constantes.TAMANIO_MAX_VARCHAR_MYSQL+" caracteres";
	public static final String ERROR_AL_ACTULIZAR_PERSONA = "Ocurrio un errror al actualizar los datos de la persona";
	public static final String USUARIO_INEXISTENTE = "Usuario inexistente";
	public static final String ATRIBUTO_DE_BUSQUEDA_SIN_COINCIDENCIAS = "No existen regitros para el atributo de bi�squeda brindado";
	public static final String OPERACION_EXITOSA = "Operacion exitosa";
	public static final String ERROR_ID_INVALIDO = "El id no es valido";
	public static final String ERROR_AL_MODIFICAR_PERSONA = "Ocurrio un errror al modificar la persona";
	public static final String ERROR_AL_ELIMINAR_PERSONA = "Ocurrio un errror al eliminar la persona";
	
	public static final String ERROR_AL_ELIMINAR_MASCOTA = "Ocurrio un errror al eliminar la mascota";
	public static final String ERROR_AL_MODIFICAR_MASCOTA = "Ocurrio un errror al modificar la mascota";
	public static final String ERROR_AL_AGREGAR_MASCOTA = "Ocurrio un errror al agregar la mascota";
	
	public static final String ERROR_AL_ELIMINAR_USUARIO = "Ocurrio un errror al eliminar el usuario.";
	public static final String ERROR_AL_MODIFICAR_USUARIO = "Ocurrio un errror al modificar el usuario";
	public static final String ERROR_AL_AGREGAR_USUARIO = "Ocurrio un errror al agregar el usuario";
	
	public static final String USUARIO_CON_MAIL_EXISTENTE = "Ya se ha registrado un usuario con el mail proporcionado. Por favor ingrese otro diferente";
	public static final String NOMBRE_APELLIDO_PERSONA_INCORRECTO =  "Nombre o apellido de persona incorrecto. No debe ser vacio ni superar los "+ Constantes.TAMANIO_MAX_VARCHAR_MYSQL + " caracteres";
	public static final String ID_USUARIO_INCORRECTO = "Id de usuario es incorrecto";
	public static final String ID_USUARIO_INEXISTENTE = "No existe usuario con el id proporcionado";
	public static final String USUARIO_CON_NUEVO_MAIL_EXISTENTE = "El mail proporcionado ya pertenece a otro usuario";
	public static final String ERROR_LOGIN = "Ocurrio un error inesperado al iniciar sesion. Comuniquese a soporte@ruffo.com.uy";
	public static final String CREDENCIALES_INCORRECTAS = "Usuario o clave incorrectas";
	public static final String USUARIO_CON_CI_EXISTENTE = "Ya se ha registrado un usuario con la CI proporcionada";
	public static final String ROL_INEXISTENTE = "Se ha proporcionado un rol invalido";
	public static final String INFORMACION_ENVIADA_FORMATO_INCORRECTO = "La informacion enviada se encuentra en un formato incorrecto";
	public static final String MAIL_CON_FORMATO_INCORRECTO = "El email no puede ser vacio y debe tener un formato correcto";
	public static final String USUARIO_SIN_PERSONA_ASOCIADA = "El usuario no tiene una persona asociada. Comuniquese con soporte de Ruffo";
	public static final String MAIL_NO_DISPONIBLE = "Mail no dispobible";
	public static final String MAIL_DISPONIBLE = "Mail dispobible";
	public static final String FORMATO_CLAVE_INCORRECTO = "La clave debe contener al menos 6 digitos";
	public static final String PAIS_INEXISTENTE = "Pais inexistente";
	public static final String FECHA_NACIMIENTO_INCORRECTA = "Fecha de nacimiento incorrecta. Recuerde ser mayor de 14 a�os";
	public static final String TIPO_USUARIO_INCORRECTO = "Tipo de usuario incorrecto";
	public static final String USUARIO_CON_ID_INEXISTENTE = "El usuario con el id proporcionado no existe";
	public static final String ERROR_AL_ACTIVAR_CUENTA = "La cuenta no se ha podido activar. Vuelva a ingresar el codigo de activacion o solicite uno nuevo";
	public static final String SEXO_INCORRECTO = "Sexo ingresado incorrecto";
	public static final String USUARIO_INACTIVO = "El usuario no se encuentra activo";
	public static final String MASCOTA_INEXISTENTE = "Mascota inexistente";
	public static final String MASCOTA_PERDIDA_INEXISTENTE = "Mascota perdida inexistente";
	public static final String ERROR_AL_OBTENER_MASCOTA = "Error al obtener la mascota";
	public static final String TIPO_COLOR_INCORRECTO = "Tipo de color es incorrecto";
	public static final String PARAMETRO_REQUERIDO = "%s es un valor requerido";
	public static final String MASCOTA_CON_NRO_CHIP_EXISTENTE = "El numero de chip ya fue asociado a una mascota";
	public static final String MASCOTA_CON_NRO_BEACON_EXISTENTE = "El numero de beacon ya fue asociado a una mascota";
	public static final String PARAMETROS_REQUERIDOS = "Los %s son valores requeridos";
	public static final String ERROR_AL_OBTENER_SEXOS_DE_MASCOTSA = "Error al obtener los sexos de las mascotas";
	public static final String ERROR_PARAMETRO_VACIO = "El %s no puede estar sin completar";
	public static final String PROPIETARIO_INEXISTENTE = "No existe un propietario que coincida con los datos proprcionados";
	public static final String TIPO_DE_MASCOTA_INEXISTENTE = "No existe un tipo de mascota que coincida con los datos proporcionados";
	public static final String TAMANIO_DE_MASCOTA_INEXISTENTE = "No existe un tamanio de mascota que coincida con los datos proporcionados";
	public static final String COLORES_MASCOTAS_INVALIDOS = "Los colores de las mascotas no son v�lidos";
	public static final String TIPOS_DE_MASCOTAS_INEXISTENTES = "No existen tipos de mascotas en el sistema";
	public static final String RAZA_INEXISTENTE = "Raza inexistente";
	public static final String ERROR_AL_OBTENER_RAZAS_DE_MASCOTSA = "No existen razas de mascotas en el sistema";
	public static final String ERROR_CODIGO_ACTIVACION = "Ocurrio un error con el codigo de activacion";
	public static final String USUARIO_EXCEDIO_LIMITE_CANTIDAD_LOGEOS = "Exedio la cantidad de intentos de iniciar sesion. Comuniquese a ruffo.info@gmail.com";
	public static final String ERROR_AL_OBTENER_CARACTERISTICAS_ESPECIALES_DE_MASCOTSA = "No existen caracteriticas especiales de mascotas en el sistema";
	public static final String PARTE_DE_MASCOTA_INCORRECTA = "La parte del cuerpo de la mascota es incorrecta";
	public static final String CARACTERISTICA_ESPECIAS_INCORRECTA = "Caracteristica especial de la mascota incorrecta";
	public static final String CARACTERISTICA_ESPECIAL_INCORRECTA_DETALLADA = "Caracteristica especial %s es incorrecta";
	public static final String PARTE_DE_MASCOTA_EXISTENTE = "Parte de la mascota existente";
	public static final String ACTIVIDAD_INCORRECTA = "Actividad incorrecta";
	public static final String MASCOTA_ENCONTRADA = "Hemos encontrado a: %s";
	public static final String COLOR_PREDOMINANTE_INCORRECTO = "Color predominante inexistente";
	public static final String COLOR_SECUNDARIO_INCORRECTO = "Color secundario inexistente";
	public static final String BUSQUEDA_SIN_RESULTADOS = "Ups! Todavia nadie ha encontrado tu mascota, no te preocupes: RUFFO la busca todos los dias y te avisa a tu email cuando la encuentre!";
	public static final String PARAMETRO_INCORRECTO = "El par�metro %s es incorrecto";
	public static final String DEPARTAMENTO_INEXISTENTE = "Departamento inexistente";
	public static final String MASCOTA_SE_ENCUENTRA_PERDIDA = "La mascota se encuentra perdida y RUFFO la busca a diario, si la elimina no se busca. �Desea continuar de todos modos?";
	public static final String ERROR_AL_CERRAR_SESION = "Error al cerrar sesion. %s";
	public static final String MASCOTA_NO_EXTRAVIADA = "No existe una mascota con el id dado que se encuentre extraviada";
	public static final String LOCALIDAD_INEXISTENTE = "Localidad inexistente";
	public static final String HISTORIA_CLINICA_INVALIDA = "No existe una historia clinica con el id brindado";
	public static final String HISTORIA_CLINICA_PARA_MASCOTA_YA_EXISTE = "Ya existe una historia clinica para la mascota";
	public static final String CONSULTA_CLINICA_INEXISTENTE = "No existe una consulta clinica con el id brindado";
	public static final String MASCOTA_NO_PERTENECE_AL_USUARIO = "La mascota %s no pertenece al usuario %s";
	public static final String CONSULTA_NO_EDITABLE_PARA_USUARIO = "Solo puede editar/eliminar tus consultas ingresadas";
	public static final String USUARIO_NO_POSEE_MASCOTAS_PERDIDAS = "No posee masctoas extraviadas.";
	public static final String MASCOTA_CON_NRO_BEACON_YA_REPORTADA = "La mascota con el n�mero de collar beacon ya se ha reportado como extraviada. �RUFFO se encuentra buscando a sus due�os!";
	public static final String MASCOTA_CON_NRO_CHIP_YA_REPORTADA = "La mascota con el n�mero de chip ya se ha reportado como extraviada. �RUFFO se encuentra buscando a sus due�os!";
	public static final String SIN_RESULTADOS_DE_BUSQUEDA = "No se obtuvieron resultados con los datos brindados.";
}