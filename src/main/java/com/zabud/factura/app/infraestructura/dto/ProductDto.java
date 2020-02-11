package com.zabud.factura.app.infraestructura.dto;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "products")
@Getter
@Setter
public class ProductDto extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String code;
	private Double Price;
	
	
	public ProductDto(Long id,String name, String code, Double price) {
		this.setId(id);
		this.name = name;
		this.code = code;
		Price = price;
	}


	public ProductDto() {

	}
	


}
