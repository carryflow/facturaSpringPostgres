package com.zabud.factura.app.shared.dominio;


import com.zabud.factura.app.exceptions.ValorTotalNoValidException;

public class ValorTotal {
	private final Double value;

	public Double getValue() {
		return value;
	}
	
	public ValorTotal(Double valorTotal) {
		this.value = valorTotal;
		
		try {
			if(valorTotal < 0)
				throw new ValorTotalNoValidException();
		} catch (NullPointerException e) {
			throw new ValorTotalNoValidException();
		}
	}

}
