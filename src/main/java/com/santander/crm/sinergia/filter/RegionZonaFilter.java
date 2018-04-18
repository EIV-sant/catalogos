package com.santander.crm.sinergia.filter;

import javax.validation.constraints.Min;

public class RegionZonaFilter {

	@Min(value = 1000, message="idRegion no debe ser menor a 1000")
	private Integer idRegion;

	@Min(value = 1100, message="idZona no debe ser menor a 1100")
	private Integer idZona;

	public Integer getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(Integer idRegion) {
		this.idRegion = idRegion;
	}

	public Integer getIdZona() {
		return idZona;
	}

	public void setIdZona(Integer idZona) {
		this.idZona = idZona;
	}

}
