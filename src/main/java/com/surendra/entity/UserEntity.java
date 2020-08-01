package com.surendra.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Entity
@Data
@Table(name="user_reg")
public class UserEntity {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue
	private Integer userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="account_status")
	private String accountStatus;
	
	@Column(name="country_id")
	private Integer countryId;
	
	@Column(name="state_id") 
	private Integer stateId;
	
	@Column(name="city_id")
	private Integer cityId;
	
	@Column(name="phno")
	private Long phno;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="gender")
	private String gender;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="created_date",updatable = false)
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="updated_date",insertable = false)
	private Date updatedDate;
	
	 
	

}
