package com.zabud.factura.app.exceptions;

public class ProductoNoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductoNoEncontradoException() {
		super("Producto no encontrado");
	}
}