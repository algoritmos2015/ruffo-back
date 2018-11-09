package com.ruffo.utils;

public class PrivilegiosChequeoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		String message = super.getMessage();
		message = "No dispone de privilegios para realizar la acción...";
		return message;
	}
}