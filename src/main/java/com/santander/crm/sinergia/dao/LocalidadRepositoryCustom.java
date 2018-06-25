package com.santander.crm.sinergia.dao;

import java.util.List;

import com.santander.crm.sinergia.entity.Localidad;

public interface LocalidadRepositoryCustom {
	
	List<Localidad> getByEstado(Integer idEdo);

}
