package com.zabud.factura.app.infraestructura.restdto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacturaRestDto {

	private Long id;
	private String nameClient;
	private List<ItemRestDao> items;
	private Double total;
}
