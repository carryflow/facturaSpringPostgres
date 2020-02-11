package com.zabud.factura.app.dominio.model;

import com.zabud.factura.app.shared.dominio.Code;
import com.zabud.factura.app.shared.dominio.Id;
import com.zabud.factura.app.shared.dominio.Name;
import com.zabud.factura.app.shared.dominio.Price;

public class Product {

	private final Id id;
	private final Name name;
	private final Code code;
	private final Price price;

	public static Product of(Id id, Name name, Code code, Price price) {
		return new Product(id, name, code, price);
	}

	public Id getId() {
		return id;
	}

	public Name getName() {
		return name;
	}

	public Code getCode() {
		return code;
	}

	public Price getPrice() {
		return price;
	}

	public Product(Id id, Name name, Code code, Price price) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.price = price;
	}

}
