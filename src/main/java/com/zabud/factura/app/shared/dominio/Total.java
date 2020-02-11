package com.zabud.factura.app.shared.dominio;

import com.zabud.factura.app.exceptions.TotalNoValidException;


public class Total {
	private final Double value;

	public Double getValue() {
		return value;
	}
	
	public Total(Double total) {
		this.value = total;
		
		try {
			if(total < 0)
				throw new TotalNoValidException();
		} catch (NullPointerException e) {
			throw new TotalNoValidException();
		}
	}

}
