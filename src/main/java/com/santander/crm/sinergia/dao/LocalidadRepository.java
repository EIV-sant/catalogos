package com.santander.crm.sinergia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.santander.crm.sinergia.entity.Localidad;

public interface LocalidadRepository extends CrudRepository<Localidad, Integer>, LocalidadRepositoryCustom{
	
	@Query("select l from Localidad l join fetch l.estado e where e.id = :idEstado ORDER BY l.nombre asc")
	List<Localidad> findAllLocalidadesByIdEstado(@Param("idEstado") Integer idEstado);

}
