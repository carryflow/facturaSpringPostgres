package com.zabud.factura.app.dominio.model;

import com.zabud.factura.app.shared.dominio.Cantidad;
import com.zabud.factura.app.shared.dominio.Id;
import com.zabud.factura.app.shared.dominio.ValorTotal;

public class Item {

	private final Id id;
	private final Product product;
	private final Cantidad cantidad;
	private final ValorTotal valorTotal;

	public static Item of(Id id, Product product, Cantidad cantidad, ValorTotal valorTotal) {
		return new Item(id, product, cantidad, valorTotal);
	}

	public Id getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public Cantidad getCantidad() {
		return cantidad;
	}

	public ValorTotal getValorTotal() {
		return valorTotal;
	}

	public Item(Id id, Product product, Cantidad cantidad, ValorTotal valorTotal) {
		super();
		this.id = id;
		this.product = product;
		this.cantidad = cantidad;
		this.valorTotal = valorTotal;
	}

}
