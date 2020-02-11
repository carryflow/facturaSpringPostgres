package com.zabud.factura.app.infraestructura.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


/*MappeSuperClass:
 * Indica que los atributos dentro de la clase será columnas dentro de las clases hijas */
@MappedSuperclass
/*
 * Es el encargado de manejar los listener de
 * los @Prepessids @Persist @PostConstruct para poder generar las columnas
 * automaticamente
 */
@EntityListeners(AuditingEntityListener.class)

public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductSeq")
	private Long id;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion", nullable = false, updatable = false)
	private Date fechaCreacion;

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ultima_modificacion")
	private Date ultimaModificacion;

	

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getUltimaModificacion() {
		return ultimaModificacion;
	}

	public void setUltimaModificacion(Date ultimaModificacion) {
		this.ultimaModificacion = ultimaModificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



}
