package com.zabud.factura.app.infraestructura.restdto;

//import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ProductRestDto {

	private Long id;
	private String name;
	private String code;
	private Double price;
	public ProductRestDto(Long id, String name, String code, double price) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.price = price;
	}
	
	public ProductRestDto() {
		// TODO Auto-generated constructor stub
	}
}