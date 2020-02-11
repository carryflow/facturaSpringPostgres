package com.zabud.factura.app.infraestructura.mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zabud.factura.app.dominio.model.Item;
import com.zabud.factura.app.infraestructura.dto.ItemDto;
import com.zabud.factura.app.infraestructura.restdto.ItemRestDao;
import com.zabud.factura.app.shared.dominio.Cantidad;
import com.zabud.factura.app.shared.dominio.Id;
import com.zabud.factura.app.shared.dominio.ValorTotal;
import com.zabud.factura.app.shared.infraestructura.mapper.MapperApi;
import com.zabud.factura.app.shared.infraestructura.mapper.MapperRepository;

@Component
public class ItemMapper implements MapperRepository<ItemDto, Item>, MapperApi<ItemRestDao, Item>{
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public ItemDto transformarDominioParaDto(Item o) {
		ItemDto itemDto = new ItemDto();
		itemDto.setId(o.getId().getValue());
		itemDto.setProducto(productMapper.transformarDominioParaDto(o.getProduct()));
		itemDto.setCantidad(o.getCantidad().getValue());
		itemDto.setValorTotal(o.getValorTotal().getValue());
		return itemDto;
	}

	@Override
	public Item transformarDtoParaDominio(ItemDto i) {
		// TODO Auto-generated method stub
		ValorTotal valorTotal = new ValorTotal(i.getCantidad()*i.getProducto().getPrice());
		return Item.of(new Id(i.getId()), productMapper.transformarDtoParaDominio(i.getProducto()), new Cantidad(i.getCantidad()), valorTotal);
	}

	@Override
	public Optional<Item> transformarDtoParaDominio(Optional<ItemDto> i) {
		if(i.isPresent())
			return Optional.empty();
		return Optional.of(this.transformarDtoParaDominio(i.get()));
	}

	@Override
	public Optional<ItemDto> transformarDominioParaDto(Optional<Item> o) {
		if(o.isPresent())
			return Optional.empty();
					
		
		return Optional.of(this.transformarDominioParaDto(o.get()));
	}

	@Override
	public ItemRestDao apiConvertirDominioParaDto(Item o) {
		// TODO Auto-generated method stub
		return new ItemRestDao(o.getId().getValue(),productMapper.apiConvertirDominioParaDto(o.getProduct()), o.getCantidad().getValue(), o.getValorTotal().getValue());
	}

	@Override
	public Item apiConvertirDtoParaDominio(ItemRestDao i) {
		// TODO Auto-generated method stub
		return Item.of(new Id(i.getId()), productMapper.apiConvertirDtoParaDominio(i.getProduct()), new Cantidad(i.getCantidad()), new ValorTotal(i.getValorTotal()));
	}

}
