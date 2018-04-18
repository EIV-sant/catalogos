package com.santander.crm.sinergia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SIN_MX_MAE_SUC")
public class Sucursal {

	@Id
	@Column(name = "NUM_CC")
	private Integer id;

	@Column(name = "TXT_NOM_SUC")
	private String nombre;

	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "SIN_MX_CAT_EDO_ID_EDO")
	private Estado estado;

	@JsonIgnore
	@ManyToOne(optional=false)
	@JoinColumn(name = "SIN_MX_CAT_LOC_ID_LOC")
	private Localidad localidad;

	@JsonIgnore
	@ManyToOne(optional=false)
	@JoinColumn(name = "SIN_MX_CAT_ZON_ID_ZON")
	private Zona zona;

	@JsonIgnore
	@ManyToOne(optional=false)
	@JoinColumn(name = "SIN_MX_CAT_REG_ID_REG")
	private Region region;

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

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}
