package com.santander.crm.sinergia.service;

import java.util.List;

import com.santander.crm.sinergia.entity.ActividadComercial;
import com.santander.crm.sinergia.entity.Banca;
import com.santander.crm.sinergia.entity.Ejecutivo;
import com.santander.crm.sinergia.entity.Estado;
import com.santander.crm.sinergia.entity.Familia;
import com.santander.crm.sinergia.entity.Localidad;
import com.santander.crm.sinergia.entity.Producto;
import com.santander.crm.sinergia.entity.Region;
import com.santander.crm.sinergia.entity.Subfamilia;
import com.santander.crm.sinergia.entity.Sucursal;
import com.santander.crm.sinergia.entity.Telefono;
import com.santander.crm.sinergia.entity.Zona;
import com.santander.crm.sinergia.filter.RegionZonaFilter;

public interface CatalogoService {

	List<Estado> getAllEstados();

	List<Localidad> getAllLocalidadesByIdEstado(Integer idEstado);

	List<Producto> getAllProductos();

	List<Banca> getAllBancas();

	List<ActividadComercial> getAllActividadesComerciales();

	List<Sucursal> getSucursalesByFilter(RegionZonaFilter filter);

	List<Sucursal> getSucursalesByLocalidad(Integer idLocalidad);
	
	List<Telefono> getAllTelefonos();
	
	List<Ejecutivo> getEjecutivosByIdTpoBca(Integer idTpoBca);
	
	List<Ejecutivo> getEjecutivosByIdZona(Integer idZona);
	
	List<Familia> getFamiliasByIdBanca(Integer idTpoBca);
	
	List<Subfamilia> getSubfamiliaByIdFamilia(Integer idFamilia);
	
	List<Region> getAllRegiones();
	
	List<Sucursal> getSucursalesByIdZona(Integer idZona);
	
	List<Zona> getZonasByIdBanca(Integer idTpoBca);

}
