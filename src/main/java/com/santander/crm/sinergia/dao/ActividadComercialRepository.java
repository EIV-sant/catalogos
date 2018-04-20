package com.santander.crm.sinergia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.santander.crm.sinergia.entity.ActividadComercial;

public interface ActividadComercialRepository extends CrudRepository<ActividadComercial, Integer> {
	
	@Query("SELECT a FROM ActividadComercial a WHERE a.disp = 1")
	List<ActividadComercial> findDisp();

}
