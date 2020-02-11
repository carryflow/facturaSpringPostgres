package com.zabud.factura.app.shared.dominio;

import com.zabud.factura.app.exceptions.CodeNoValidException;

public class Code {

	private final String value;

	public String getValue() {
		return value;
	}
	
	public Code(String code) {
		this.value = code;
		
		try {
			if(code.length() <= 3)
				throw new CodeNoValidException();
		} catch (NullPointerException e) {
			throw new CodeNoValidException();
		}
	}
	
}
