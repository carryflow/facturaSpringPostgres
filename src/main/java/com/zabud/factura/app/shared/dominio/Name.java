package com.zabud.factura.app.shared.dominio;

import com.zabud.factura.app.exceptions.NameNoValidException;

public class Name {

	private final String value;

	public String getValue() {
		return value;
	}

	public Name(String name) {
		this.value = name;

		try {
			if (name.length() < 2 )
				throw new NameNoValidException();
		} catch (NullPointerException e) {
			throw new NameNoValidException();
		}

	}
}
