package com.santander.crm.sinergia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SIN_MX_CAT_FAM")
public class Familia {
	
	@Id
	@Column(name = "ID_CONS_FAM")
	private Integer id;

	@Column(name = "ID_FAM")
	private Integer idFamilia;
	
	@Column(name = "TXT_FML")
	private String nombre;
	
	@JsonIgnore
	@ManyToOne(optional=false)
	@JoinColumn(name = "ID_TPO_BCA")
	private Banca banca;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(Integer idFamilia) {
		this.idFamilia = idFamilia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Banca getBanca() {
		return banca;
	}

	public void setBanca(Banca banca) {
		this.banca = banca;
	}

}
