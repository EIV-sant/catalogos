package com.santander.crm.sinergia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.santander.crm.sinergia.entity.Subfamilia;

public interface SubFamiliaRepository extends CrudRepository<Subfamilia, String> {
	
	@Query("SELECT sf FROM Subfamilia sf JOIN FETCH sf.banca b WHERE sf.idFamilia = :idFamilia AND b.id = :idTpoBca ORDER BY idOrden  ")
	List<Subfamilia> getSubfamiliaByIdFamilia(@Param("idFamilia") Integer idFamilia, @Param("idTpoBca") Integer idTpoBca);

}
