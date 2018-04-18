package com.santander.crm.sinergia.service;

import java.util.List;

import com.santander.crm.sinergia.entity.ActividadComercial;
import com.santander.crm.sinergia.entity.Banca;
import com.santander.crm.sinergia.entity.Estado;
import com.santander.crm.sinergia.entity.EstadoCivil;
import com.santander.crm.sinergia.entity.Localidad;
import com.santander.crm.sinergia.entity.Producto;
import com.santander.crm.sinergia.entity.Sucursal;
import com.santander.crm.sinergia.filter.RegionZonaFilter;

public interface CatalogoService {
	
	List<Estado> getAllEstados();
	
	List<Localidad> getAllLocalidadesByIdEstado(Integer idEstado);
	
	List<Producto> getAllProductos();
	
	List<Banca> getAllBancas();
	
	List<ActividadComercial> getAllActividadesComerciales();
	
	List<EstadoCivil> getAllEstadosCiviles();
	
	List<Sucursal> getSucursalesByFilter(RegionZonaFilter filter);
	
	List<Sucursal> getSucursalesByLocalidad(Integer idLocalidad);
	
}
