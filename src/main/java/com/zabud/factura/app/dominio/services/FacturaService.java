package com.zabud.factura.app.dominio.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zabud.factura.app.dominio.model.Factura;
import com.zabud.factura.app.shared.dominio.Id;

public interface FacturaService {

	public List<Factura> findAll();

	public Factura save(Factura factura);

	public void deleteById(Id id);

	public Factura findById(Id id);
	
	public Page<Factura> facturasPaginadas(Pageable pageable);
}
