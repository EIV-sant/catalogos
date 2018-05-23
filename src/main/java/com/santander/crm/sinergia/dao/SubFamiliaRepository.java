package com.santander.crm.sinergia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.santander.crm.sinergia.entity.Subfamilia;

public interface SubFamiliaRepository extends CrudRepository<Subfamilia, String> {
	
	@Query("SELECT sf FROM Subfamilia sf WHERE sf.idFamilia = :idFamilia ")
	List<Subfamilia> getSubfamiliaByIdFamilia(@Param("idFamilia") Integer idFamilia);

}
