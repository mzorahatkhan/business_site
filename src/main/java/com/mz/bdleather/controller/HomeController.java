package com.mz.bdleather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mz.bdleather.entities.Customer;

@Controller
public class HomeController {
	
	@GetMapping("")
	public String displayHome()
	{
		return"index";
	}
	
	@GetMapping("/register")
	public String displayRegistration(Customer customer)
	{
		return"registration";
	}

	@GetMapping("/login")
	public String showLoginPage()
	{
		return"customer-login";
	}
	
	
	
}
