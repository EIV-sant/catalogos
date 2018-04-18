package com.santander.crm.sinergia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.santander.crm.sinergia.entity.Sucursal;

public interface SucursalRepository extends CrudRepository<Sucursal, Integer>, SucursalRepositoryCustom {
	
	@Query("SELECT s FROM Sucursal s JOIN FETCH s.localidad l where l.id = :idLocalidad")
	List<Sucursal> findSucursalesByIdLocalidad (@Param("idLocalidad") Integer idLocalidad);
}
