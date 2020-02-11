package com.zabud.factura.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*
 * EnableJpaAuditing es el encargado de decirle a Spring que se va a auditar las
 * entidades
 */

@EnableJpaAuditing

public class FacturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacturaApplication.class, args);
	}

}
