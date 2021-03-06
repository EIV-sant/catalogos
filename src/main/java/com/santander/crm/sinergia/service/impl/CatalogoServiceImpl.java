package com.santander.crm.sinergia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.crm.sinergia.dao.ActividadComercialRepository;
import com.santander.crm.sinergia.dao.BancaRepository;
import com.santander.crm.sinergia.dao.EjecutivoRepository;
import com.santander.crm.sinergia.dao.EstadoRepository;
import com.santander.crm.sinergia.dao.FamiliaRepository;
import com.santander.crm.sinergia.dao.LocalidadRepository;
import com.santander.crm.sinergia.dao.RegionRepository;
import com.santander.crm.sinergia.dao.SubFamiliaRepository;
import com.santander.crm.sinergia.dao.SucursalRepository;
import com.santander.crm.sinergia.dao.TelefonoRepository;
import com.santander.crm.sinergia.dao.ZonaRepository;
import com.santander.crm.sinergia.entity.ActividadComercial;
import com.santander.crm.sinergia.entity.Banca;
import com.santander.crm.sinergia.entity.Ejecutivo;
import com.santander.crm.sinergia.entity.Estado;
import com.santander.crm.sinergia.entity.Familia;
import com.santander.crm.sinergia.entity.Localidad;
import com.santander.crm.sinergia.entity.Region;
import com.santander.crm.sinergia.entity.Subfamilia;
import com.santander.crm.sinergia.entity.Sucursal;
import com.santander.crm.sinergia.entity.Telefono;
import com.santander.crm.sinergia.entity.Zona;
import com.santander.crm.sinergia.filter.RegionZonaFilter;
import com.santander.crm.sinergia.service.CatalogoService;

@Service("catalogoServiceImpl")
public class CatalogoServiceImpl implements CatalogoService {

	@Autowired
	protected EstadoRepository estadoRepository;

	@Autowired
	protected LocalidadRepository localidadRepository;

	@Autowired
	protected BancaRepository bancaRepository;

	@Autowired
	protected ActividadComercialRepository actividadComercialRepository;

	@Autowired
	protected SucursalRepository sucursalRepository;

	@Autowired
	protected TelefonoRepository telefonoRepository;

	@Autowired
	protected EjecutivoRepository ejecutivoRepository;

	@Autowired
	protected FamiliaRepository familiaRepository;

	@Autowired
	protected SubFamiliaRepository subFamiliaRepository;

	@Autowired
	protected RegionRepository regionRepository;

	@Autowired
	protected ZonaRepository zonaRepository;

	@Override
	public List<Estado> getAllEstados() {
		return (List<Estado>) estadoRepository.findAll();
	}

	@Override
	public List<Localidad> getAllLocalidadesByIdEstado(Integer idEstado) {
		return localidadRepository.findAllLocalidadesByIdEstado(idEstado);
//		return localidadRepository.getByEstado(idEstado);
	}

	@Override
	public List<Banca> getAllBancas() {
		return (List<Banca>) bancaRepository.findAll();
	}

	@Override
	public List<ActividadComercial> getAllActividadesComerciales() {
		return actividadComercialRepository.findDisp();
	}

	@Override
	public List<Sucursal> getSucursalesByFilter(RegionZonaFilter filter) {
		return sucursalRepository.getSucursalesByFilter(filter);
	}

	@Override
	public List<Sucursal> getSucursalesByLocalidad(Integer idLocalidad) {
		return sucursalRepository.findSucursalesByIdLocalidad(idLocalidad);
	}

	@Override
	public List<Telefono> getAllTelefonos() {
		return (List<Telefono>) telefonoRepository.findAll();
	}

	@Override
	public List<Ejecutivo> getEjecutivosByIdTpoBca(Integer idTpoBca) {
		return ejecutivoRepository.findEjecutivosByIdTpoBca(idTpoBca);
	}

	@Override
	public List<Ejecutivo> getEjecutivosByIdZona(Integer idZona) {
		return ejecutivoRepository.findEjecutivosByIdZona(idZona);
	}

	@Override
	public List<Familia> getFamiliasByIdBanca(Integer idTpoBca) {
		return familiaRepository.getFamiliasByIdBanca(idTpoBca);
	}

	@Override
	public List<Subfamilia> getSubfamiliaByIdFamilia(Integer idFamilia, Integer idTpoBca) {
		return subFamiliaRepository.getSubfamiliaByIdFamilia(idFamilia, idTpoBca);
	}

	@Override
	public List<Region> getAllRegiones() {
		return regionRepository.getAllRegiones();
	}

	@Override
	public List<Sucursal> getSucursalesByIdZona(Integer idZona) {
		return sucursalRepository.getSucursalesByIdZona(idZona);
	}

	@Override
	public List<Zona> getZonasByIdBanca(Integer idTpoBca, Integer idRegion) {
		switch(idTpoBca) {
		case 1:
		case 2:
			return zonaRepository.getZonasByIdBancaIsNull(idRegion);
		case 3:
			return zonaRepository.getZonasByIdBanca(idTpoBca, idRegion);
		}
		return null;
//		if (idTpoBca == null) { // si es null trae zonas que vienen nulas, q equivalen a banca 1 y 2
//			return zonaRepository.getZonasByIdBancaIsNull();
//		} else if (idTpoBca == 3) {
//				return zonaRepository.getZonasByIdBanca(idTpoBca);
//			} else { // zonas con banca 1 o 2 son null en base
//				return zonaRepository.getZonasByIdBancaIsNull();
//			}
//		}

	}

}
