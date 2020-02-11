package com.zabud.factura.app.exceptions;

//Es una clase que se extiende RunTimeException y sobre escribe la su mensaje
public class RegistroNoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RegistroNoEncontradoException() {
		super("No se ha encontrado registro de la consulta realizada");
		// En el super se coloca el mensaje que se quiere cuando ocurra la excepcion
	}
}
