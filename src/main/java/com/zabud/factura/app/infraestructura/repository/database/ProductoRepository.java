package com.zabud.factura.app.infraestructura.repository.database;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zabud.factura.app.infraestructura.dto.ProductDto;

public interface ProductoRepository extends JpaRepository<ProductDto, Long> {
	
   @Query("from com.zabud.factura.app.infraestructura.dto.ProductDto")
   Page<ProductDto> findAllPagedAsDto(Pageable pageRequest);

}
