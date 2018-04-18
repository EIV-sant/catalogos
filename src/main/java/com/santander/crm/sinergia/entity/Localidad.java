package com.santander.crm.sinergia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "SIN_MX_CAT_LOC")
public class Localidad {

	@Id
	@Column(name = "ID_LOC")
	private Integer id;

	@Column(name = "TXT_LOCALIDAD")
	private String nombre;

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SIN_MX_CAT_EDO_ID_ESTADO", referencedColumnName = "ID_EDO")
	private Estado estado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
