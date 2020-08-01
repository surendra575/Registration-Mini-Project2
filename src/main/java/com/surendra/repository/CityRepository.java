package com.surendra.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surendra.entity.CityEntity;


public interface CityRepository extends JpaRepository<CityEntity, Serializable> {
	public List <CityEntity> findAllByStateId(int stateId);

}
