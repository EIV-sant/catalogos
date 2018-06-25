package com.santander.crm.sinergia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
import com.santander.crm.sinergia.service.CatalogoService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping("/sinergia")
public class CatalogosController {
	
	@Autowired
	@Qualifier("catalogoServiceImpl")
	protected CatalogoService catalogoService;
	
	/**
	 * Endpoint para recuperar el catálogo de estados
	 * @return Lista de Estados
	 */
	@RequestMapping(value = "/catalogos/estados", method = { RequestMethod.GET })
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Estado>> estados(){
		HttpStatus hs = HttpStatus.OK;		
		HttpHeaders header = new HttpHeaders();
		
		List<Estado> response = catalogoService.getAllEstados();
		
		return new ResponseEntity<List<Estado>>(response, header, hs);
	}
	
	/**
	 * Endpoint para recuperar el catálogo de localidades de un estado
	 * @param idEstado el identificador del estado
	 * @return Lista de localidades
	 */
	@RequestMapping(value = "/catalogos/estados/{idEstado}/localidades", method = { RequestMethod.GET })
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Localidad>> localidades(@PathVariable Integer idEstado){
		HttpStatus hs = HttpStatus.OK;		
		HttpHeaders header = new HttpHeaders();
		
		List<Localidad> response = catalogoService.getAllLocalidadesByIdEstado(idEstado);
		for (Localidad loc : response) {
			System.out.println("n-->"+loc.getNombre());
		}
		return new ResponseEntity<List<Localidad>>(response, header, hs);
	}
	
	/**
	 * Endpoint para recuperar el catálogo de bancas
	 * @return Lista de bancas
	 */
	@RequestMapping(value = "/catalogos/bancas", method = { RequestMethod.GET })
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Banca>> bancas(){
		HttpStatus hs = HttpStatus.OK;		
		HttpHeaders header = new HttpHeaders();
		
		List<Banca> response = catalogoService.getAllBancas();
		
		return new ResponseEntity<List<Banca>>(response, header, hs);
	}
	
	/**
	 * Endpoint para recuperar el catálogo de actividades comerciales
	 * @return Lista de actividades comerciales
	 */
	@RequestMapping(value = "/catalogos/actividadesComerciales", method = { RequestMethod.GET })
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<ActividadComercial>> actividadesComerciales(){
		HttpStatus hs = HttpStatus.OK;		
		HttpHeaders header = new HttpHeaders();
		
		List<ActividadComercial> response = catalogoService.getAllActividadesComerciales();
		
		return new ResponseEntity<List<ActividadComercial>>(response, header, hs);
	}
	
	/**
	 * Endpoint para recuperar el catálogo de sucursales de una localidad
	 * @param idLocalidad el identificador de la localidad
	 * @return Lista de sucursales
	 */
	@RequestMapping(value = "/catalogos/sucursales/{idLocalidad}", method = { RequestMethod.GET })
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Sucursal>> sucursalesByLocalidad(@PathVariable Integer idLocalidad){
		HttpStatus hs = HttpStatus.OK;		
		HttpHeaders header = new HttpHeaders();
		
		List<Sucursal> response = catalogoService.getSucursalesByLocalidad(idLocalidad);
		
		return new ResponseEntity<List<Sucursal>>(response, header, hs);
	}
	
	/**
	 * Endpoint para recuperar el catálogo de tipos de telefono
	 * @return Lista de tipos de telefono
	 */
	@RequestMapping(value = "/catalogos/telefonos", method = { RequestMethod.GET })
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Telefono>> telefonos(){
		HttpStatus hs = HttpStatus.OK;		
		HttpHeaders header = new HttpHeaders();
		
		List<Telefono> response = catalogoService.getAllTelefonos();
		
		return new ResponseEntity<List<Telefono>>(response, header, hs);
	}
	
	/**
	 * Endpoint test para comprobar disponibilidad de micro servicio
	 * @return
	 */
	@RequestMapping(value = "catalogos/pruebas", method = { RequestMethod.GET })
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> pruebas() {
		
		HttpStatus hs = HttpStatus.OK;		
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<String>("Hola mundo...",header, hs);
	}
	
	/**
	 * Endpoint para recuperar el catálogo de ejecutivos de una banca
	 * @param idTpoBca el identificador de la banca
	 * @return Lista de ejecutivos
	 */
	@RequestMapping(value = "/catalogos/ejecutivo/{idTpoBca}", method = { RequestMethod.GET })
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Ejecutivo>> ejecutivosByBanca(@PathVariable Integer idTpoBca){
		HttpStatus hs = HttpStatus.OK;		
		HttpHeaders header = new HttpHeaders();
		
		List<Ejecutivo> response = catalogoService.getEjecutivosByIdTpoBca(idTpoBca);
		
		return new ResponseEntity<List<Ejecutivo>>(response, header, hs);
	}
	
	/**
	 * Endpoint para recuperar el catálogo de ejecutivos BEI
	 * @param idZona el num_cc
	 * @return Lista de ejecutivos
	 */
	@RequestMapping(value = "/catalogos/ejecutivosBei/{idZona}", method = { RequestMethod.GET })
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Ejecutivo>> ejecutivosByIdZona(@PathVariable Integer idZona) {
		
		HttpStatus hs = HttpStatus.OK;		
		HttpHeaders header = new HttpHeaders();
		
		List<Ejecutivo> response = catalogoService.getEjecutivosByIdZona(idZona);
		
		return new ResponseEntity<List<Ejecutivo>>(response, header, hs);
	}
	
	/**
	 * Endpoint para recuperar el catálogo de familias de una banca
	 * @param idTpoBca el identificador de la banca
	 * @return Lista de familias
	 */
	@RequestMapping(value = "/catalogos/familias/{idTpoBca}", method = { RequestMethod.GET })
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Familia>> familiasByBanca(@PathVariable Integer idTpoBca){
		HttpStatus hs = HttpStatus.OK;		
		HttpHeaders header = new HttpHeaders();
		
		List<Familia> response = catalogoService.getFamiliasByIdBanca(idTpoBca);
		
		return new ResponseEntity<List<Familia>>(response, header, hs);
	}
	
	/**
	 * Endpoint para recuperar el catálogo de subfamilias de una familia
	 * @param idFamilia el identificador de la familia
	 * @return Lista de sufamilias
	 */
	@RequestMapping(value = "/catalogos/subfamilias/{idFamilia}/{idTpoBca}", method = { RequestMethod.GET })
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Subfamilia>> sufamiliasBy(@PathVariable Integer idFamilia, @PathVariable("idTpoBca") Integer idTpoBca){
		HttpStatus hs = HttpStatus.OK;		
		HttpHeaders header = new HttpHeaders();
		
		List<Subfamilia> response = catalogoService.getSubfamiliaByIdFamilia(idFamilia, idTpoBca);
		
		return new ResponseEntity<List<Subfamilia>>(response, header, hs);
	}
	
	/**
	 * Endpoint para recuperar el catálogo de regiones
	 * @return Lista de regiones
	 */
	@RequestMapping(value = "/catalogos/regiones", method = { RequestMethod.GET })
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Region>> regiones(){
		HttpStatus hs = HttpStatus.OK;		
		HttpHeaders header = new HttpHeaders();
		
		List<Region> response = catalogoService.getAllRegiones();
		
		return new ResponseEntity<List<Region>>(response, header, hs);
	}
	
	/**
	 * Endpoint para recuperar el catálogo de zonas de una banca
	 * @param idTpoBca el identificador de la banca
	 * @return Lista de zonas
	 */
	@RequestMapping(value = "/catalogos/zona/{idTpoBca}/{idRegion}", method = { RequestMethod.GET })
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Zona>> zonasByBanca(@PathVariable("idTpoBca") Integer idTpoBca, @PathVariable("idRegion") Integer idRegion){
		HttpStatus hs = HttpStatus.OK;		
		HttpHeaders header = new HttpHeaders();
		List<Zona> response = catalogoService.getZonasByIdBanca(idTpoBca, idRegion);
		
		return new ResponseEntity<List<Zona>>(response, header, hs);
	}
	
	/**
	 * Endpoint para recuperar el catálogo de sucursales de una zona
	 * @param idZona el identificador de la zona
	 * @return Lista de sucursales
	 */
	@RequestMapping(value = "/catalogos/sucursal/{idZona}", method = { RequestMethod.GET })
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Sucursal>> sucursalesByZona(@PathVariable Integer idZona){
		HttpStatus hs = HttpStatus.OK;		
		HttpHeaders header = new HttpHeaders();
		
		List<Sucursal> response = catalogoService.getSucursalesByIdZona(idZona);
		
		return new ResponseEntity<List<Sucursal>>(response, header, hs);
	}

}
