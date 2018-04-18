package com.santander.crm.sinergia.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "SIN_MX_CAT_EDO")
public class Estado {

	@Id
	@Column(name = "ID_EDO")
	private Integer id;

	@Column(name = "TXT_ESTADO")
	private String nombre;

	@JsonBackReference
	@OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Localidad> localidades = new ArrayList<>();

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

	public List<Localidad> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(List<Localidad> localidades) {
		this.localidades = localidades;
	}

	public void addLocalidad(Localidad localidad) {
		localidades.add(localidad);
		localidad.setEstado(null);
	}

	public void removeLocalidad(Localidad localidad) {
		localidades.remove(localidad);
		localidad.setEstado(null);
	}

}
