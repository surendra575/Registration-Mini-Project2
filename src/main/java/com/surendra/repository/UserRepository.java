package com.surendra.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.surendra.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Serializable> {
	
	public UserEntity findByEmail(String email);
	
	@Query("select password from UserEntity where email=:email")
	public String getPwdByEmail(String email);
	
	@Transactional
	@Modifying
	@Query("update UserEntity u set u.password=:pwd,u.accountStatus=:status where u.email=:email")
	public Integer updatePazzword(String email,String pwd,String status);
	
	
	public UserEntity findByEmailAndPassword(String email,String password);
	
	@Query("select accountStatus from UserEntity where email=:email")
	public String getAcctStatus(String email);
	
	

}
