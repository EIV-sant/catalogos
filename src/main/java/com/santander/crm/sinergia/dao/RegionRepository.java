package com.santander.crm.sinergia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.santander.crm.sinergia.entity.Region;

public interface RegionRepository extends CrudRepository<Region, String> {
	
	@Query("SELECT r FROM Region r WHERE r.flg = 1")
	List<Region> getAllRegiones();

}
