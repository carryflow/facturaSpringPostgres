package com.zabud.factura.app.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zabud.factura.app.dominio.model.Product;
import com.zabud.factura.app.dominio.services.ProductService;
import com.zabud.factura.app.exceptions.RegistroNoEncontradoException;
import com.zabud.factura.app.infraestructura.mapper.ProductMapper;
import com.zabud.factura.app.infraestructura.restdto.ProductRestDto;
import com.zabud.factura.app.shared.dominio.Id;

public class ProductApplication {

	private ProductService productService;

	private ProductMapper productMapper;

	public ProductApplication(@Autowired ProductService productService, ProductMapper productMapper) {
		this.productService = productService;
		this.productMapper = productMapper;
	}

//	función para guardar productos
	public ProductRestDto save(ProductRestDto productRestDto) {
		Product product = productService.save(productMapper.apiConvertirDtoParaDominio(productRestDto));
		return productMapper.apiConvertirDominioParaDto(product);
	}

//  función para obtener producto por su ID
	public ProductRestDto findById(Long id) {
		return productMapper.apiConvertirDominioParaDto(productService.findById(new Id(id)).get());
	}

//	función para listar todos los productos
	public List<ProductRestDto> findProductos() {
		return productMapper.apitransformarListDominioParaDto(productService.findAll());
	}

//  función para eliminar producto por su ID
	public void delete(Long id) {
		productService.deleteById(
				productService.findById(new Id(id)).orElseThrow(() -> new RegistroNoEncontradoException()).getId());
	}

// función para actualizar un producto
	public ProductRestDto update(ProductRestDto productoA) {
		Product product = null;
		if (productService.findById(new Id(productoA.getId()))
				.orElseThrow(() -> new RegistroNoEncontradoException()) != null) {

			product = productService.save(productMapper.apiConvertirDtoParaDominio(productoA));

		}

		return productMapper.apiConvertirDominioParaDto(product);

	}

// función para listar productos paginados
	public Page<ProductRestDto> productPaginated(Pageable pageable) {

		return productMapper.apitransformarPageDominioParaDto(productService.findPageable(pageable));
	}

}
