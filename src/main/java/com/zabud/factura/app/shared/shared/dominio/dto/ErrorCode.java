package com.zabud.factura.app.shared.shared.dominio.dto;

public class ErrorCode {
	private String codigo;
	private String mensaje;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public ErrorCode() {
		// TODO Auto-generated constructor stub
	}
}
