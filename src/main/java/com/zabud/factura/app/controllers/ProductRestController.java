package com.zabud.factura.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zabud.factura.app.application.ProductApplication;
import com.zabud.factura.app.dominio.services.ProductService;
import com.zabud.factura.app.infraestructura.mapper.ProductMapper;
//import com.zabud.factura.app.dominio.services.ProductService;
//import com.zabud.factura.app.infraestructura.mapper.ProductMapper;
import com.zabud.factura.app.infraestructura.restdto.ProductRestDto;

@RestController
@RequestMapping("/api")
public class ProductRestController {

	private ProductApplication productApplication;

	public ProductRestController(@Autowired ProductService productService, ProductMapper productMapper) {
		this.productApplication = new ProductApplication(productService, productMapper);
	}

	@PostMapping("/products")
	public ProductRestDto crear(@RequestBody ProductRestDto producto) {
		return productApplication.save(producto);
	}

	@GetMapping("/products")
	public List<ProductRestDto> listarProductos() {
		return productApplication.findProductos();
	}

	@GetMapping("products/{id}")
	public ProductRestDto buscar(@PathVariable Long id) {
		return productApplication.findById(id);

	}

	@DeleteMapping("products/{id}")
	public void eliminar(@PathVariable Long id) {
		productApplication.delete(id);
	}

	@PutMapping("/products")
	public ProductRestDto actualizar(@RequestBody ProductRestDto productoA) {
		return productApplication.update(productoA);
	}

	@GetMapping("/products/page/{page}")
	public Page<ProductRestDto> productPageables(@PathVariable Integer page) {
		return productApplication.productPaginated(PageRequest.of(page, 5));
	}
}
