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
import com.santander.crm.sinergia.entity.Estado;
import com.santander.crm.sinergia.entity.Localidad;
import com.santander.crm.sinergia.entity.Producto;
import com.santander.crm.sinergia.entity.Sucursal;
import com.santander.crm.sinergia.entity.Telefono;
import com.santander.crm.sinergia.service.CatalogoService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping("/sinergia")
public class CatalogosController {
	
	@Autowired
	@Qualifier("catalogoServiceImpl")
	CatalogoService catalogoService;
	
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
		
		return new ResponseEntity<List<Localidad>>(response, header, hs);
	}
	
	/**
	 * Endpoint para recuperar el catálogo de productos
	 * @return Lista de productos
	 */
	@RequestMapping(value = "/catalogos/productos", method = { RequestMethod.GET })
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Producto>> productos(){
		HttpStatus hs = HttpStatus.OK;		
		HttpHeaders header = new HttpHeaders();
		
		List<Producto> response = catalogoService.getAllProductos();
		
		return new ResponseEntity<List<Producto>>(response, header, hs);
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

}
