package com.zabud.factura.app.infraestructura.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="facturas_items")
public class ItemDto extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer cantidad;
	private Double valorTotal;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@OneToOne(targetEntity = ProductDto.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id")
	private ProductDto producto;

}
