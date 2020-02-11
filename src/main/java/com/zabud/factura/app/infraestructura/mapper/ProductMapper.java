package com.zabud.factura.app.infraestructura.mapper;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.zabud.factura.app.dominio.model.Product;
import com.zabud.factura.app.infraestructura.dto.ProductDto;
import com.zabud.factura.app.infraestructura.restdto.ProductRestDto;
import com.zabud.factura.app.shared.dominio.Code;
import com.zabud.factura.app.shared.dominio.Id;
import com.zabud.factura.app.shared.dominio.Name;
import com.zabud.factura.app.shared.dominio.Price;
import com.zabud.factura.app.shared.infraestructura.mapper.MapperApi;
import com.zabud.factura.app.shared.infraestructura.mapper.MapperRepository;

@Component
public class ProductMapper  implements MapperRepository<ProductDto, Product>, MapperApi<ProductRestDto, Product>{

	@Override
	public ProductDto transformarDominioParaDto(Product o) {
		// TODO Auto-generated method stub
		ProductDto productDto = new ProductDto();
		productDto.setId(o.getId().getValue());
		productDto.setName(o.getName().getValue());
		productDto.setCode(o.getCode().getValue());
		productDto.setPrice(o.getPrice().getValue());
		return productDto;
	}

	@Override
	public Product transformarDtoParaDominio(ProductDto i) {
		
		return Product.of(new Id(i.getId()), new Name(i.getName()), new Code(i.getCode()), new Price(i.getPrice()));
	}

	@Override
	public Optional<Product> transformarDtoParaDominio(Optional<ProductDto> i) {
		if(!i.isPresent())
			return Optional.empty();
		
		return Optional.of(this.transformarDtoParaDominio(i.get()));
	}

	@Override
	public Optional<ProductDto> transformarDominioParaDto(Optional<Product> o) {
		if(!o.isPresent())
			return Optional.empty();
		
		return Optional.of(this.transformarDominioParaDto(o.get()));
	}

	@Override
	public ProductRestDto apiConvertirDominioParaDto(Product o) {
		return new ProductRestDto(o.getId().getValue(),o.getName().getValue(),o.getCode().getValue(),o.getPrice().getValue());
	}

	@Override
	public Product apiConvertirDtoParaDominio(ProductRestDto i) {
		return  Product.of(new Id(i.getId()), new Name(i.getName()), new Code(i.getCode()), new Price(i.getPrice()));
	}

}
