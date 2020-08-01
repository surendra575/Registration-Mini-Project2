package com.surendra.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.surendra.binding.User;
import com.surendra.service.UserServiceImpl;

@Controller
public class RegistrationController {
	@Autowired
	private UserServiceImpl ser;
	
	@GetMapping("/signup")
	public String loadHomePage(Model model)
	{
		User user=new User();
		model.addAttribute("user", user);
		
		Map<Integer, String> allCountries = ser.getAllCountries();
		model.addAttribute("countries", allCountries);
		
		return "registration";
		
	}
	
	@PostMapping("/addUser")
	public String handlingFormData(@ModelAttribute("user") User user,RedirectAttributes ra,Model model)
	{
		System.out.println("DOB:--------->"+user.getDob());
		boolean res = ser.registerUser(user);
		if(res)
		{
			return "regSucc";
		}
		else
		{
			return "er"; 
		}
	}
	
	@GetMapping("/validateEmail")
	@ResponseBody
	public String validatingEmail(@RequestParam("email") String email)
	{
		String result = ser.validateEmail(email);
		return  result;
	}
	
	@RequestMapping("/getStates")
	@ResponseBody
	public Map<Integer,String> getStatesByCountryId(@RequestParam("cid")Integer countryId)
	{
		return ser.getAllStatesByCountryId(countryId);
	}
	
	
	@RequestMapping("/getCities")
	@ResponseBody
	public Map<Integer,String> getAllCitiesByStateId(@RequestParam("sid") Integer sid)
	{
		return ser.getAllCitiesByStateId(sid);
	}

}
