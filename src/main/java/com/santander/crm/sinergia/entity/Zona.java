package com.santander.crm.sinergia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SIN_MX_CAT_ZON")
public class Zona {

	@Id
	@Column(name = "ID_ZON")
	private Integer id;

	@Column(name = "TXT_NOM_ZON")
	private String nombre;
	
	@Column(name = "FLG_VIS")
	private Integer flg;
	
	@Column(name = "ID_TPO_BCA")
	private Integer idBanca;
	
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

	public Integer getFlg() {
		return flg;
	}

	public void setFlg(Integer flg) {
		this.flg = flg;
	}

	public Integer getIdBanca() {
		return idBanca;
	}

	public void setIdBanca(Integer idBanca) {
		this.idBanca = idBanca;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}
