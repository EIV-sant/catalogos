package com.santander.crm.sinergia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.santander.crm.sinergia.entity.Estado;

public interface EstadoRepository extends CrudRepository<Estado, Integer>{
	
	@Query("select e from Estado e")
	List<Estado> findAllEstados();
	

}
