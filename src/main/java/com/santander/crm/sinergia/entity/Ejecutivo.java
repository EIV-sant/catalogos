package com.santander.crm.sinergia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SIN_MX_CAT_EJEC")
public class Ejecutivo {

	@Id
	@Column(name = "TXT_OFI_ACT")
	private String ofiAct;

	@Column(name = "TXT_NOM_EJV")
	private String nombre;
	
	@JsonIgnore
	@ManyToOne(optional=true)
	@JoinColumn(name = "COD_CVE_BAN")
	private Banca banca;

	public String getOfiAct() {
		return ofiAct;
	}

	public void setOfiAct(String ofiAct) {
		this.ofiAct = ofiAct;
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
