package com.zabud.factura.app.infraestructura.mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zabud.factura.app.dominio.model.Factura;
import com.zabud.factura.app.infraestructura.dto.FacturaDto;
import com.zabud.factura.app.infraestructura.restdto.FacturaRestDto;
import com.zabud.factura.app.shared.dominio.Id;
import com.zabud.factura.app.shared.dominio.NameClient;
import com.zabud.factura.app.shared.dominio.Total;
import com.zabud.factura.app.shared.infraestructura.mapper.MapperApi;
import com.zabud.factura.app.shared.infraestructura.mapper.MapperRepository;

@Component
public class FacturaMapper implements MapperRepository<FacturaDto, Factura>, MapperApi<FacturaRestDto, Factura> {
	
	@Autowired
	private ItemMapper itemMapper;

	@Override
	public FacturaDto transformarDominioParaDto(Factura o) {
		FacturaDto facturaDto = new FacturaDto();
		facturaDto.setId(o.getId().getValue());
		facturaDto.setNameClient(o.getNameClient().getValue());
		facturaDto.setItems(itemMapper.transformarListDominioParaDto(o.getItems()));
		facturaDto.setTotal(o.getTotal().getValue());
		return facturaDto;
	}

	@Override
	public Factura transformarDtoParaDominio(FacturaDto i) {
		// TODO Auto-generated method stub
		return Factura.of(new Id(i.getId()), new NameClient(i.getNameClient()), itemMapper.transformarListaDtoParaDominio(i.getItems()), new Total(i.getTotal()));
	}

	@Override
	public Optional<Factura> transformarDtoParaDominio(Optional<FacturaDto> i) {
		// TODO Auto-generated method stub
		if(i.isPresent())
			return Optional.empty();
		
		return Optional.of(this.transformarDtoParaDominio(i.get()));
	}

	@Override
	public Optional<FacturaDto> transformarDominioParaDto(Optional<Factura> o) {
		// TODO Auto-generated method stub
		if(o.isPresent())
			return Optional.empty();
		return Optional.of(transformarDominioParaDto(o.get()));
	}

	@Override
	public FacturaRestDto apiConvertirDominioParaDto(Factura o) {
		// TODO Auto-generated method stub
		FacturaRestDto facturaRestDto = new FacturaRestDto();
		facturaRestDto.setId(o.getId().getValue());
		facturaRestDto.setNameClient(o.getNameClient().getValue());
		facturaRestDto.setItems(itemMapper.apitransformarListDominioParaDto(o.getItems()));
		facturaRestDto.setTotal(o.getTotal().getValue());
		return facturaRestDto;
	}

	@Override
	public Factura apiConvertirDtoParaDominio(FacturaRestDto i) {
		// TODO Auto-generated method stub
		return Factura.of(new Id(i.getId()), new NameClient(i.getNameClient()), itemMapper.apitransformarListaDtoParaDominio(i.getItems()), new Total(i.getTotal()));
	}

}
