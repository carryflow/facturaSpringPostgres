package com.zabud.factura.app.shared.dominio;

import com.zabud.factura.app.exceptions.PriceNoValidException;

public class Price {

	private final Double value;

	public Double getValue() {
		return value;
	}
	
	public Price(Double price) {
		this.value = price;
		
		try {
			if(price < 0)
				throw new PriceNoValidException();
		} catch (NumberFormatException e) {
			throw new PriceNoValidException();
		}
	}
}
