package com.santander.crm.sinergia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SIN_MX_CAT_ACT")
public class ActividadComercial {

	@Id
	@Column(name = "ID_ACT")
	private Integer id;

	@Column(name = "TXT_DESC_ACT")
	private String nombre;

	@Column(name = "VAL_DISP")
	private Integer disp;

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

	public Integer getDisp() {
		return disp;
	}

	public void setDisp(Integer disp) {
		this.disp = disp;
	}

}
