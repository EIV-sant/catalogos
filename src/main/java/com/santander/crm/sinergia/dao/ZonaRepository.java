package com.santander.crm.sinergia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.santander.crm.sinergia.entity.Zona;

public interface ZonaRepository extends CrudRepository<Zona, String> {
	
	@Query("SELECT z FROM Zona z JOIN FETCH z.region r WHERE z.flg = 1 AND z.idBanca = :idTpoBca AND r.id = :idRegion")
	List<Zona> getZonasByIdBanca(@Param ("idTpoBca") Integer idTpoBca, @Param ("idRegion") Integer idRegion);
	
	@Query("SELECT z FROM Zona z JOIN FETCH z.region r WHERE z.flg = 1 AND z.idBanca IS NULL AND r.id = :idRegion")
	List<Zona> getZonasByIdBancaIsNull(@Param ("idRegion") Integer idRegion);

}
