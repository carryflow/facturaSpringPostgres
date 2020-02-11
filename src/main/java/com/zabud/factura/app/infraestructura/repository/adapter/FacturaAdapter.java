package com.zabud.factura.app.infraestructura.repository.adapter;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zabud.factura.app.dominio.model.Factura;
import com.zabud.factura.app.dominio.services.FacturaService;
import com.zabud.factura.app.exceptions.RegistroNoEncontradoException;
import com.zabud.factura.app.infraestructura.dto.FacturaDto;
import com.zabud.factura.app.infraestructura.mapper.FacturaMapper;
import com.zabud.factura.app.infraestructura.repository.database.FacturaRepository;
import com.zabud.factura.app.shared.dominio.Id;

@Service
public class FacturaAdapter implements FacturaService {
	
	@Autowired
	private FacturaRepository facturaRepository;
	
	@Autowired
	private FacturaMapper facturaMapper;

	@Override
	public List<Factura> findAll() {
		// TODO Auto-generated method stub
		return facturaMapper.transformarListaDtoParaDominio(facturaRepository.findAll());
	}

	@Override
	public Factura save(Factura factura) {
		// TODO Auto-generated method stub
		FacturaDto facturaDto = facturaRepository.save(facturaMapper.transformarDominioParaDto(factura));
		
		return facturaMapper.transformarDtoParaDominio(facturaDto);
	}

	@Override
	public void deleteById(Id id) {
		// TODO Auto-generated method stub
		facturaRepository.deleteById(id.getValue());

	}

	@Override
	public Factura findById(Id id) {
		//System.out.println(id.getValue());
		// TODO Auto-generated method stub
		return facturaMapper.transformarDtoParaDominio(facturaRepository.findById(id.getValue()).orElseThrow(()-> new RegistroNoEncontradoException()));
	}

	@Override
	public Page<Factura> facturasPaginadas(Pageable pageable) {
		// TODO Auto-generated method stub
		return facturaMapper.transformarPageDtoParaDominio(facturaRepository.findAll(pageable));
	}
	
	

}
