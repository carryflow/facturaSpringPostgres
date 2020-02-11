package com.zabud.factura.app.shared.infraestructura.mapper;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

public interface MapperApi<RestDto, Dominio> {
	public RestDto apiConvertirDominioParaDto(Dominio o);

	public Dominio apiConvertirDtoParaDominio(RestDto i);

	public default List<Dominio> apitransformarListaDtoParaDominio(List<RestDto> instancias) {
		return instancias.stream().map(i -> apiConvertirDtoParaDominio(i)).collect(Collectors.toList());
	}

	public default Page<Dominio> apitransformarPageDtoParaDominio(Page<RestDto> instancias) {

		return instancias.map(new Function<RestDto, Dominio>() {
			@Override
			public Dominio apply(RestDto t) {
				// TODO Auto-generated method stub
				return apiConvertirDtoParaDominio(t);
			}
		});
	}

	public default List<RestDto> apitransformarListDominioParaDto(List<Dominio> instancias) {
		return instancias.stream().map(o -> apiConvertirDominioParaDto(o)).collect(Collectors.toList());
	}

	public default Page<RestDto> apitransformarPageDominioParaDto(Page<Dominio> instancias) {

		return instancias.map(new Function<Dominio, RestDto>() {
			@Override
			public RestDto apply(Dominio t) {
				// TODO Auto-generated method stub
				return apiConvertirDominioParaDto(t);
			}
		});
	}

}
