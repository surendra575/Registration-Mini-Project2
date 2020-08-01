package com.surendra.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="city")
@Data
public class CityEntity{
	@Id
	@GeneratedValue
	@Column(name="city_id")
	private int cityId;

	@Column(name="state_id")
	private int stateId;

	@Column(name="city_name")
	private String cityName;
}