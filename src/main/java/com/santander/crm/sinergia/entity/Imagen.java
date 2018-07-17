package com.santander.crm.sinergia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "SIN_MX_MAE_IMG")
public class Imagen {

	@Id
	@Column(name = "ID_IMG")
	private Integer id;

	@Lob
	@Column(name = "BLOB_IMG")
	private byte[] imagen;

	@Column(name = "TXT_NOM_IMG")
	private String nombre;
	
    public Imagen() {
	}

	public Imagen(Integer id, String nombre, byte[] imagen) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
