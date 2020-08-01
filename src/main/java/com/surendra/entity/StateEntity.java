package com.surendra.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="state")
@Data
public class StateEntity{
	@Id
	@GeneratedValue
	@Column(name="state_id")
	private int stateId;

	@Column(name="country_id")
	private int countryId;

	@Column(name="state_name")
	private String stateName;
}