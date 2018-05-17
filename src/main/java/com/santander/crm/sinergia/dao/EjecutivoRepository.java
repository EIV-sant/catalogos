package com.santander.crm.sinergia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.santander.crm.sinergia.entity.Ejecutivo;

public interface EjecutivoRepository extends CrudRepository<Ejecutivo, Integer> {
	
	@Query("SELECT e FROM Ejecutivo e JOIN FETCH e.banca b where b.id = :idTpoBca")
	List<Ejecutivo> findEjecutivosByIdTpoBca (@Param("idTpoBca") Integer idTpoBca);

}
