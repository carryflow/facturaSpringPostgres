package com.zabud.factura.app.infraestructura.repository.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zabud.factura.app.dominio.model.Product;
import com.zabud.factura.app.dominio.services.ProductService;
import com.zabud.factura.app.infraestructura.dto.ProductDto;
import com.zabud.factura.app.infraestructura.mapper.ProductMapper;
import com.zabud.factura.app.infraestructura.repository.database.ProductoRepository;
import com.zabud.factura.app.shared.dominio.Id;

@Service
public class ProductAdapter implements ProductService {
	
	@Autowired
	private ProductoRepository productRepository;
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productMapper.transformarListaDtoParaDominio(productRepository.findAll());
	}

	@Override
	public Product save(Product producto) {
		// TODO Auto-generated method stub
		ProductDto productDto = productRepository.save(productMapper.transformarDominioParaDto(producto));
		return productMapper.transformarDtoParaDominio(productDto);
		
	}
 
	@Override
	public void deleteById(Id id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id.getValue());
	}

	@Override
	public Optional<Product> findById(Id id) {
		// TODO Auto-generated method stub
		return productMapper.transformarDtoParaDominio(productRepository.findById(id.getValue()));
	}


	@Override
	public Page<Product> findPageable(Pageable pageable) {
		return productMapper.transformarPageDtoParaDominio(productRepository.findAll(pageable));
	}

}
