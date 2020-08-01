package com.surendra.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="country")
@Data
public class CountryEntity{
	@Id
	@GeneratedValue
	@Column(name="country_id")
	private int countryId;
	
	@Column(name="country_name")
	private String countryName;
}