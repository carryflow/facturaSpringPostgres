package com.zabud.factura.app.infraestructura.restdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemRestDao {

	private Long id;
	private ProductRestDto product;
	private Integer cantidad;
	private Double valorTotal;
}
