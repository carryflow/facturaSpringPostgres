package com.zabud.factura.app.infraestructura.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zabud.factura.app.infraestructura.dto.ItemDto;

public interface ItemRepository extends JpaRepository<ItemDto, Long> {

}
