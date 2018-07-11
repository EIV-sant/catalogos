package com.santander.crm.sinergia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.santander.crm.sinergia.entity.Familia;

public interface FamiliaRepository extends CrudRepository<Familia, String> {
	
	@Query("SELECT f FROM Familia f JOIN FETCH f.banca b WHERE b.id = :idTpoBca ORDER BY idOrden ")
	List<Familia> getFamiliasByIdBanca(@Param("idTpoBca") Integer idTpoBca);

}
