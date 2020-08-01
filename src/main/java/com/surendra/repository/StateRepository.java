package com.surendra.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surendra.entity.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, Serializable> {
	
	public List <StateEntity> findAllByCountryId(int countryId);

}
