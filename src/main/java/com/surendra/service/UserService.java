package com.surendra.service;

import java.util.Map;

import com.surendra.binding.User;

public interface UserService {
	public boolean registerUser(User user);
	public Map<Integer,String> getAllCountries();
	public Map<Integer,String> getAllStatesByCountryId(int countryId);
	public Map<Integer,String> getAllCitiesByStateId(int stateId);
	
	public String findPwdByEmail(String email);
	public int updatePwd(String email,String pwd);
	public boolean checkCredentials(String email,String pwd);
	public boolean checkAcctStatus(String email);
	public boolean checkEmail(String email);
	public boolean checkEmailForLogin(String email);
	public boolean sendPazzwordToMobile(String email);
	public Long getPhoneNumberByEmail(String email);

}
