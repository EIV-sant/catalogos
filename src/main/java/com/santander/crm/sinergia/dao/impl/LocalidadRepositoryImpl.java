package com.santander.crm.sinergia.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.santander.crm.sinergia.dao.LocalidadRepositoryCustom;
import com.santander.crm.sinergia.entity.Estado;
import com.santander.crm.sinergia.entity.Localidad;

public class LocalidadRepositoryImpl implements LocalidadRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Localidad> getByEstado(Integer idEdo) {
		
		Query query = entityManager.createNativeQuery("select * \n" + 
				"from SIN_MX_CAT_LOC \n" + 
				"where SIN_MX_CAT_EDO_ID_ESTADO = :idEdo \n" + 
				"order by TXT_LOCALIDAD", Localidad.class);
		query.setParameter("idEdo", idEdo);
		List<Localidad> locList = query.getResultList();
		query = entityManager.createQuery("select e from Estado e where e.id = :idEdo", Estado.class);
		query.setParameter("idEdo", idEdo);
		Estado e = (Estado)query.getSingleResult();
		for (Localidad localidad : locList) {
			localidad.setEstado(e);
		}
		return locList;
		
	}

}
