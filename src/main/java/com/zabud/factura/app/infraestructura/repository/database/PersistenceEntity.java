package com.zabud.factura.app.infraestructura.repository.database;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
 * Esta clase es la que le dice a Spring 
 *que todos los repositorios va a a estar
 * a una ruta especifica*/
@EnableJpaRepositories({ "com.zabud.factura.app.repository",
		"com.zabud.factura.app.infraestructura.repository.database" }) // Se coloca el nombre del paquete donde se
public class PersistenceEntity {

}
