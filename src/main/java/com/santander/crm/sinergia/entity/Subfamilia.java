package com.santander.crm.sinergia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SIN_MX_CAT_SUB_FAM")
public class Subfamilia {
	
	@Id
	@Column(name = "ID_CONS_SFAM")
	private Integer id;

	@Column(name = "ID_FAM")
	private Integer idFamilia;
	
	@Column(name = "ID_SUB_FML")
	private Integer idSubFamilia;
	
	@Column(name = "TXT_SUB_FML")
	private String nombre;

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

	public Integer getIdSubFamilia() {
		return idSubFamilia;
	}

	public void setIdSubFamilia(Integer idSubFamilia) {
		this.idSubFamilia = idSubFamilia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
