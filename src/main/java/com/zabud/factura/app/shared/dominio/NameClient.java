package com.zabud.factura.app.shared.dominio;

import com.zabud.factura.app.exceptions.NameClientNoValidException;


public class NameClient {
	private final String value;

	public String getValue() {
		return value;
	}

	public NameClient(String nameClient) {
		this.value = nameClient;

		try {
			if (nameClient.length() < 2)
				throw new NameClientNoValidException();
		} catch (NullPointerException e) {
			throw new NameClientNoValidException();
		}

	}
}
