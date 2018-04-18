package com.santander.crm.sinergia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.crm.sinergia.dao.ActividadComercialRepository;
import com.santander.crm.sinergia.dao.BancaRepository;
import com.santander.crm.sinergia.dao.EstadoCivilRepository;
import com.santander.crm.sinergia.dao.EstadoRepository;
import com.santander.crm.sinergia.dao.LocalidadRepository;
import com.santander.crm.sinergia.dao.ProductoRepository;
import com.santander.crm.sinergia.dao.SucursalRepository;
import com.santander.crm.sinergia.entity.ActividadComercial;
import com.santander.crm.sinergia.entity.Banca;
import com.santander.crm.sinergia.entity.Estado;
import com.santander.crm.sinergia.entity.EstadoCivil;
import com.santander.crm.sinergia.entity.Localidad;
import com.santander.crm.sinergia.entity.Producto;
import com.santander.crm.sinergia.entity.Sucursal;
import com.santander.crm.sinergia.filter.RegionZonaFilter;
import com.santander.crm.sinergia.service.CatalogoService;

@Service("catalogoServiceImpl")
public class CatalogoServiceImpl implements CatalogoService {
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	LocalidadRepository localidadRepository;
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	BancaRepository bancaRepository;
	
	@Autowired
	ActividadComercialRepository actividadComercialRepository;
	
	@Autowired
	EstadoCivilRepository estadoCivilRepository;
	
	@Autowired
	SucursalRepository sucursalRepository;

	@Override
	public List<Estado> getAllEstados() {
		return (List<Estado>) estadoRepository.findAll();
	}

	@Override
	public List<Localidad> getAllLocalidadesByIdEstado(Integer idEstado) {
		return localidadRepository.findAllLocalidadesByIdEstado(idEstado);
	}

	@Override
	public List<Producto> getAllProductos() {
		return (List<Producto>) productoRepository.findAll();
	}

	@Override
	public List<Banca> getAllBancas() {
		return (List<Banca>) bancaRepository.findAll();
	}

	@Override
	public List<ActividadComercial> getAllActividadesComerciales() {
		return (List<ActividadComercial>) actividadComercialRepository.findAll();
	}

	@Override
	public List<EstadoCivil> getAllEstadosCiviles() {
		return (List<EstadoCivil>) estadoCivilRepository.findAll();
	}

	@Override
	public List<Sucursal> getSucursalesByFilter(RegionZonaFilter filter) {
		return sucursalRepository.getSucursalesByFilter(filter);
	}

	@Override
	public List<Sucursal> getSucursalesByLocalidad(Integer idLocalidad) {
		return sucursalRepository.findSucursalesByIdLocalidad(idLocalidad);
	}


}
