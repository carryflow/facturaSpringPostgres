package com.zabud.factura.app.dominio.model;

import java.util.List;

import com.zabud.factura.app.shared.dominio.Id;
import com.zabud.factura.app.shared.dominio.NameClient;
import com.zabud.factura.app.shared.dominio.Total;

public class Factura {
	private final Id id;
	private final NameClient nameClient;
	private final List<Item> items;
	private final Total total;

	public static Factura of(Id id, NameClient nameClient, List<Item> item, Total total) {
		return new Factura(id, nameClient, item, total);
	}

	public Id getId() {
		return id;
	}

	public NameClient getNameClient() {
		return nameClient;
	}

	

	public List<Item> getItems() {
		return items;
	}

	public Total getTotal() {
		return total;
	}

	public Factura(Id id, NameClient nameClient, List<Item> items, Total total) {
		this.id = id;
		this.nameClient = nameClient;
		this.items = items;
		this.total = total;
	}
	
	

	

}
