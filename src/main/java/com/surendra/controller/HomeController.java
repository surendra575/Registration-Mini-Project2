package com.surendra.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.surendra.binding.Login;

@Controller
public class HomeController {
	Logger logger=LoggerFactory.getLogger(HomeController.class);
	
	
	
	@GetMapping("/home")
	public String loadHomePage(Model model)
	{
		logger.debug("******loadHomePage method execution started******");
		Login l=new Login();
		model.addAttribute("login", l);
		logger.debug("******loadHomePage method execution ended******");
		return "home";
	}

}
