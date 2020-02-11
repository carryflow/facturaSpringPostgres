package com.zabud.factura.app.exceptions;

public class CantidadItemNoValidaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CantidadItemNoValidaException() {
		super("Cantidad ingresada en el item no es valida");
	}
}
