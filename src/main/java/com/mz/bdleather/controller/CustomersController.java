package com.mz.bdleather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mz.bdleather.entities.Customer;
import com.mz.bdleather.services.CustomerService;

@Controller
@RequestMapping("")
public class CustomersController {
	@Autowired
	CustomerService custService; //this is creating instance of customer service which is dependent on customer repo
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@GetMapping("/user_register")
	public String userRegistration(Model model) 
	{
		Customer aCustomer=new Customer();
		//this is adding attribute to model 
		model.addAttribute("customer",aCustomer);
		return "customer/registration";
	}
	@PostMapping("/register")
	public String completeRegistration(Customer customer, Model model)
	{
		customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
		//this is adding object to repo
		custService.save(customer);
		return"redirect:/user_register";
	}

}
