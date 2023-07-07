package com.mz.bdleather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mz.bdleather.entities.Customer;

@Controller
@RequestMapping("")
public class HomeController {
	//this endpoint will show the home page
	@GetMapping("")
	public String displayHome()
	{
		return"index";
	}
	
	//here clicking register in home page is redirected to Customer controller /user_register endpoints.
	@GetMapping("/register")
	public String displayRegistration(Customer customer)
	{
		return"redirect:/user_register";
	}
    //after clciking login in homepage ,its redirct to /loginForm in loginController
	@GetMapping("/login")
	public String showLoginPage()
	{
		return"redirect:/customer/loginForm";
	}
	
	//this is the post mapping where after clicking login ,its redircted to this method 
	@PostMapping("/customer_login")
	public String returnToHomePage()
	{
		return"redirect:/";
	}
	
	
	
}
