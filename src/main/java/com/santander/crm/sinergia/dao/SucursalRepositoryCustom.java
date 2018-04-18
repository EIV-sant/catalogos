package com.santander.crm.sinergia.dao;

import java.util.List;

import com.santander.crm.sinergia.entity.Sucursal;
import com.santander.crm.sinergia.filter.RegionZonaFilter;

public interface SucursalRepositoryCustom {
	
	List<Sucursal> getSucursalesByFilter(RegionZonaFilter filter);
	
	List<Sucursal> getSucursalesByFilter(Integer idLocalidad);

}
