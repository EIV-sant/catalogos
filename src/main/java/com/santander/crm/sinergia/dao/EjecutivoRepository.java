package com.santander.crm.sinergia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.santander.crm.sinergia.entity.Ejecutivo;

public interface EjecutivoRepository extends CrudRepository<Ejecutivo, Integer> {
	
	@Query("SELECT e FROM Ejecutivo e JOIN FETCH e.banca b where b.id = :idTpoBca ORDER BY e.nombre ")
	List<Ejecutivo> findEjecutivosByIdTpoBca (@Param("idTpoBca") Integer idTpoBca);
	
	@Query("SELECT e FROM Ejecutivo e JOIN FETCH e.banca b JOIN FETCH e.tipo t where b.id = 3 AND t.id in (81, 65) AND e.idSucursal = :idZona AND e.expediente IS NOT NULL ORDER BY e.nombre")
	List<Ejecutivo> findEjecutivosByIdZona (@Param("idZona") Integer idZona);

}
