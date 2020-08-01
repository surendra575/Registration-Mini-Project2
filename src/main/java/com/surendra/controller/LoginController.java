package com.surendra.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.surendra.binding.Login;
import com.surendra.exception.RegistrationException;
import com.surendra.service.UserServiceImpl;

@Controller
public class LoginController {
	
	Logger logger=LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserServiceImpl ser;

	@PostMapping("/login")
	public String progilePage(@ModelAttribute("login") Login login, Model model) {
		logger.debug("******profilePage method execution started******");
		String page = "";
		try {
		boolean emailAvail = ser.checkEmailForLogin(login.getEmail());
		
		//int a=10/0;
		if (emailAvail) {
			logger.info("******emailId valid********");
			boolean res = ser.checkCredentials(login.getEmail(), login.getPassword());
			boolean sts = ser.checkAcctStatus(login.getEmail());

			System.out.println("credentials: " + res + " status: " + sts);

			if (res && sts) {
				logger.info("******both credentials,status unlocked********");
				model.addAttribute("msg", "Welcome to suryasoft...your profile page is under construction...");
				page = "profile";
			} else if (!res) {
				logger.info("******invalid credentials********");
				model.addAttribute("er", "Invalid credentials..!!");
				page = "home";
			} else if (!sts) {
				logger.info("******status is locked********");
				model.addAttribute("er", "Your account was locked...");
				page = "home";
			}
			
		} else {
			logger.info("******emailId not valid********");
			model.addAttribute("er", "Invalid email ID....!!!");
			page = "home";
		}
		
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			throw new RegistrationException("Login functionality failed");
		}
		logger.debug("******profilePage method execution ended******");
		return page;
	}

}
