package com.santander.crm.sinergia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.santander.crm.sinergia.entity.Zona;

public interface ZonaRepository extends CrudRepository<Zona, String> {
	
	@Query("SELECT z FROM Zona z WHERE z.flg = 1 AND z.idBanca = :idTpoBca")
	List<Zona> getZonasByIdBanca(@Param ("idTpoBca") Integer idTpoBca);
	
	@Query("SELECT z FROM Zona z WHERE z.flg = 1 AND z.idBanca IS NULL")
	List<Zona> getZonasByIdBancaIsNull();

}
