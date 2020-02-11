package com.zabud.factura.app.shared.infraestructura.mapper;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

public interface MapperRepository<Dto, Dominio> {
	public Dto transformarDominioParaDto(Dominio o);//

	public Dominio transformarDtoParaDominio(Dto i);

	public Optional<Dominio> transformarDtoParaDominio(Optional<Dto> i);

	public Optional<Dto> transformarDominioParaDto(Optional<Dominio> o);

	public default List<Dominio> transformarListaDtoParaDominio(List<Dto> instancias) {
		return instancias.stream().map(i -> transformarDtoParaDominio(i)).collect(Collectors.toList());
	}

	public default Page<Dominio> transformarPageDtoParaDominio(Page<Dto> instancias) {
		return instancias.map(new Function<Dto, Dominio>() {
			@Override
			public Dominio apply(Dto t) {
				// TODO Auto-generated method stub
				return transformarDtoParaDominio(t);
			}

		});
	}

	public default List<Dto> transformarListDominioParaDto(List<Dominio> instancias) {
		return instancias.stream().map(o -> transformarDominioParaDto(o)).collect(Collectors.toList());
	}

	public default Page<Dto> transformarPageDominioParaDto(Page<Dominio> instancias) {
		return instancias.map(new Function<Dominio, Dto>() {

			@Override
			public Dto apply(Dominio t) {
				// TODO Auto-generated method stub
				return transformarDominioParaDto(t);
			}
		});
	}

}