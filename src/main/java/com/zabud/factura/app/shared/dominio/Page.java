package com.zabud.factura.app.shared.dominio;

import org.springframework.data.domain.Pageable;

public class Page {

	private final Pageable value;
	
	
	
	public Pageable getValue() {
		return value;
	}



	public Page(Pageable page) {
		this.value = page;
		// TODO Auto-generated constructor stub
	}
}
