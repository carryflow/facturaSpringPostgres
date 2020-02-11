package com.zabud.factura.app.dominio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zabud.factura.app.dominio.model.Product;
import com.zabud.factura.app.shared.dominio.Id;


public interface ProductService {
	
	public List<Product> findAll();

	public Product save(Product producto);

	public void deleteById(Id id);

	public Optional<Product> findById(Id id);
	
	public Page<Product> findPageable(Pageable pageable);
	
}
