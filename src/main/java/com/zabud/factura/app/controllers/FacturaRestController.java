package com.zabud.factura.app.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zabud.factura.app.application.FacturaApplication;
import com.zabud.factura.app.dominio.services.FacturaService;
import com.zabud.factura.app.dominio.services.ProductService;
import com.zabud.factura.app.infraestructura.mapper.FacturaMapper;
import com.zabud.factura.app.infraestructura.mapper.ProductMapper;
import com.zabud.factura.app.infraestructura.restdto.FacturaRestDto;


@RestController
@RequestMapping("/api")
public class FacturaRestController {

	private FacturaApplication facturaApplication;

	public FacturaRestController(@Autowired FacturaService facturaService, FacturaMapper facturaMapper, ProductService productService, ProductMapper productMapper) {
		// TODO Auto-generated constructor stub
		this.facturaApplication = new FacturaApplication(facturaService, facturaMapper, productService, productMapper);
	}

	@PostMapping("/facturas")
	public FacturaRestDto crear(@RequestBody FacturaRestDto facturaDto) {
		return facturaApplication.save(facturaDto);
	}
	
	@GetMapping("/facturas")
	public List<FacturaRestDto> findAll() {
		return facturaApplication.findFacturas();
	}
	
	@GetMapping("/facturas/{id}")
	public FacturaRestDto findByid(@PathVariable Long id) {
		return facturaApplication.findByid(id);
		
	}
	
	@PutMapping("/facturas")
	public FacturaRestDto update(@RequestBody FacturaRestDto factura) {
		return facturaApplication.updateFactura(factura);
	}
	
	@DeleteMapping("/facturas/{id}")
	public void delete(@PathVariable Long id) {
		facturaApplication.deleteByid(id);
	}


}
