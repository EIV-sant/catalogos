package com.santander.crm.sinergia.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.santander.crm.sinergia.dao.SucursalRepositoryCustom;
import com.santander.crm.sinergia.entity.Sucursal;
import com.santander.crm.sinergia.filter.RegionZonaFilter;

@Repository
public class SucursalRepositoryImpl implements SucursalRepositoryCustom {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Sucursal> getSucursalesByFilter(RegionZonaFilter filter) {
		
		boolean param = false;
		StringBuffer sQuery = new StringBuffer(); 
		sQuery.append("SELECT s FROM Sucursal s ");
		
		if(filter.getIdRegion() != null || filter.getIdZona() != null ) {
			System.out.println("Trae parametros");
			sQuery.append("JOIN FETCH s.region r JOIN FETCH s.zona z WHERE ");
			if(filter.getIdRegion() != null) {
				sQuery.append("r.id = " + filter.getIdRegion() + " ");
				param = true;
			}
			if(filter.getIdZona() != null) {
				if(param)
					sQuery.append("AND ");
				sQuery.append("z.id = " + filter.getIdZona() + " ");
			}
		}
		
		Query query = entityManager.createQuery(sQuery.toString(), Sucursal.class);
		
		return query.getResultList();
		
	}

	@Override
	public List<Sucursal> getSucursalesByFilter(Integer idLocalidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
