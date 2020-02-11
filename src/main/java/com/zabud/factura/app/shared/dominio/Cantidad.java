package com.zabud.factura.app.shared.dominio;

import com.zabud.factura.app.exceptions.PriceNoValidException;

public class Cantidad {

	private final Integer value;

	public Integer getValue() {
		return value;
	}
	
	public Cantidad(Integer cantidad) {
		this.value = cantidad;
		
		try {
			if(cantidad < 0)
				throw new PriceNoValidException();
		} catch (NullPointerException e) {
			throw new PriceNoValidException();
		}
	}
}
