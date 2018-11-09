package com.ruffo.utils;

public class SeguridadChequeoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		String message = super.getMessage();
		message = "No se encuentra logeado en el sistema...";
		return message;
	}
}
