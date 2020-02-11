package com.zabud.factura.app.application;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zabud.factura.app.dominio.model.Factura;
import com.zabud.factura.app.dominio.services.FacturaService;
import com.zabud.factura.app.dominio.services.ProductService;

//import com.zabud.factura.app.dominio.services.ProductService;
import com.zabud.factura.app.infraestructura.mapper.FacturaMapper;
import com.zabud.factura.app.infraestructura.mapper.ProductMapper;
//import com.zabud.factura.app.infraestructura.mapper.ProductMapper;
import com.zabud.factura.app.infraestructura.restdto.FacturaRestDto;
import com.zabud.factura.app.infraestructura.restdto.ItemRestDao;
import com.zabud.factura.app.infraestructura.restdto.ProductRestDto;
import com.zabud.factura.app.shared.dominio.Id;

public class FacturaApplication {

	private FacturaService facturaService;

	private FacturaMapper facturaMapper;

	private ProductService productService;

	private ProductMapper productMapper;

	public FacturaApplication(FacturaService facturaService, FacturaMapper facturaMapper, ProductService productService,
			ProductMapper productMapper) {
		this.facturaService = facturaService;
		this.facturaMapper = facturaMapper;
		this.productService = productService;
		this.productMapper = productMapper;
	}

//Funcion para listar todas las facturas en la base de datos
	public List<FacturaRestDto> findFacturas() {
		return facturaMapper.apitransformarListDominioParaDto(facturaService.findAll());
	}

//Funcion para guardar una factura con sus items 
	public FacturaRestDto save(FacturaRestDto factura) {
		this.LoadProductToItems(factura);
		this.totalItem(factura);
		this.TotalFactura(factura);
		Factura factu = facturaService.save(facturaMapper.apiConvertirDtoParaDominio(factura));
		return facturaMapper.apiConvertirDominioParaDto(factu);
	}

//	Funcion para calcular el total por iten de la factura
	public void totalItem(FacturaRestDto factura) {
		factura.getItems().forEach((item) -> {
			ProductRestDto productRestDto = productMapper
					.apiConvertirDominioParaDto(productService.findById(new Id(item.getProduct().getId())).get());
			item.setValorTotal(item.getCantidad() * productRestDto.getPrice());
//			System.out.println(item.getCantidad()+" "+productRestDto.getPrice());
		});
	}

//Funcion  para calcular total de la factura
	public void TotalFactura(FacturaRestDto factura) {
		Double totalFactura = 0.00;
		for (ItemRestDao item : factura.getItems()) {
			totalFactura += item.getValorTotal();
		}
		factura.setTotal(totalFactura);
//		System.out.println(totalFactura);
	}

//Funcion para cargar productos en la lista de items de la factura
	public void LoadProductToItems(FacturaRestDto factura) {
		factura.getItems().forEach(item -> {
			item.setProduct(productMapper
					.apiConvertirDominioParaDto(productService.findById(new Id(item.getProduct().getId())).get()));
		});
	}

// funcion para consultar facturas por su ID	
	public FacturaRestDto findByid(Long id) {
		return facturaMapper.apiConvertirDominioParaDto(facturaService.findById(new Id(id)));
	}

// funcion para actualizar factura
	public FacturaRestDto updateFactura(FacturaRestDto factura) {
		Factura factu = null;
		if (facturaService.findById(new Id(factura.getId())) != null) {
			this.LoadProductToItems(factura);
			this.totalItem(factura);
			this.TotalFactura(factura);
			factu = facturaService.save(facturaMapper.apiConvertirDtoParaDominio(factura));
		}

		return facturaMapper.apiConvertirDominioParaDto(factu);
	}

//funcion para eliminar factura por ID
	public void deleteByid(Long id) {
		facturaService.deleteById(new Id(id));
	}
	
//función para listar facturas paginadas
	public Page<FacturaRestDto> facturasPaginadas(Pageable pageable){
		return facturaMapper.apitransformarPageDominioParaDto(facturaService.facturasPaginadas(pageable));
		
	}

}
