package com.surendra.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surendra.binding.User;
import com.surendra.constants.AppConstants;
import com.surendra.entity.CityEntity;
import com.surendra.entity.CountryEntity;
import com.surendra.entity.StateEntity;
import com.surendra.entity.UserEntity;
import com.surendra.repository.CityRepository;
import com.surendra.repository.CountryRepository;
import com.surendra.repository.StateRepository;
import com.surendra.repository.UserRepository;
import com.surendra.utils.EmailUtility;
import com.surendra.utils.ForgotPwdUtility;
import com.surendra.utils.PwdUtility;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repo;
	@Autowired
	private CountryRepository crepo;
	@Autowired
	private StateRepository srepo;
	@Autowired
	private CityRepository cityRepo;
	
	@Autowired
	private PwdUtility pu;
	
	@Autowired
	private EmailUtility eu;
	
	
	
	@Autowired
	private ForgotPwdUtility fpu;

	@Override
	public boolean registerUser(User user) {
		String pwd=pu.generatePassword();
		System.out.println("Password: "+pwd);
		String accountStatus=AppConstants.ACCT_STATUS;
		
		user.setPassword(pwd);
		user.setAccountStatus(accountStatus);
	
		
		UserEntity e=new UserEntity();
		e.setFirstName(user.getFirstName());
		e.setLastName(user.getLastName());
		e.setPassword(user.getPassword());
		e.setAccountStatus(user.getAccountStatus());
		e.setEmail(user.getEmail());
		e.setPhno(user.getPhno());
		e.setDob(user.getDob());
		e.setGender(user.getGender());
		e.setCountryId(user.getCountry());
		e.setStateId(user.getState());
		e.setCityId(user.getCity());
		
		
		
		UserEntity save = repo.save(e);
		if(save.getFirstName()!=null)
		{
			System.out.println("Mail properly sent...."+eu.sendMail(user));
			return eu.sendMail(user);
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	public String validateEmail(String email)
	{
		UserEntity ue = repo.findByEmail(email); 
		if(ue!=null)
		{
			System.out.println("*******Its duplicate email*********");
			return "duplicate";
		}
		else
		{
			return "unique";
		}
	}

	@Override
	public Map<Integer, String> getAllCountries() {
		
		Map<Integer,String> cmap=new HashMap<>();
		
		List<CountryEntity> allCountries = crepo.findAll();
		
		for(CountryEntity cs:allCountries)
		{
			cmap.put(cs.getCountryId(), cs.getCountryName());
		}
		
		return cmap;
	}

	@Override
	public Map<Integer, String> getAllStatesByCountryId(int countryId) {
		Map<Integer,String> smap=new HashMap<>();
		List<StateEntity> findAllByCountryId = srepo.findAllByCountryId(countryId);
		
		for(StateEntity se:findAllByCountryId)
		{
			smap.put(se.getStateId(), se.getStateName());
		}
		return smap;
	}

	@Override
	public Map<Integer, String> getAllCitiesByStateId(int stateId) {
		
		
		Map<Integer,String> citymap=new HashMap<>();
		List<CityEntity> findAllByCityId = cityRepo.findAllByStateId(stateId);
		
		for(CityEntity ce:findAllByCityId)
		{
			citymap.put(ce.getCityId(), ce.getCityName());
		}
		return citymap;
	}




	@Override
	public String findPwdByEmail(String email) {
		String pazz = repo.getPwdByEmail(email);
		return pazz;
	}




	@Override
	public int updatePwd(String email, String pwd) {
		String st=AppConstants.AFTER_ACCT_STATUS;
		Integer res = repo.updatePazzword(email, pwd,st);
		return res;
	}




	@Override
	public boolean checkCredentials(String email, String pwd) {
		UserEntity en = repo.findByEmailAndPassword(email, pwd);
		if(en!=null)
		{
			return true;
		}
		return false;
	}




	@Override
	public boolean checkAcctStatus(String email) {
		String status = repo.getAcctStatus(email);
		if(status.equals(AppConstants.ACCT_STATUS))
			return false;
		else
		{
			return true;
		}
	}




	@Override
	public boolean checkEmail(String email) {
		UserEntity ue = repo.findByEmail(email);	
		if(ue!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public boolean sendPazzwordToMobile(String email) {
		UserEntity ue = repo.findByEmail(email);
		Long phno=ue.getPhno();
		String pwd=ue.getPassword();
		boolean res=fpu.sendPwdMsg(phno, pwd);
		if(res)
			return true;
		return false;
	}
	
	@Override
	public Long getPhoneNumberByEmail(String email) {
		UserEntity ue = repo.findByEmail(email);
		Long phno=ue.getPhno();
		return phno;
	}
	@Override
	public boolean checkEmailForLogin(String email) {
		UserEntity uen = repo.findByEmail(email);
		if(uen!=null)
			return true;
		return false;
	}

}
