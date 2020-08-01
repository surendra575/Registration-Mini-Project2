package com.surendra.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surendra.entity.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Serializable>{

}
