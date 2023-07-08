package com.mz.bdleather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mz.bdleather.dao.CustomerRepository;
import com.mz.bdleather.entities.Customer;

@Controller
@RequestMapping("")
public class CustomersController {
	@Autowired
	CustomerRepository custRepo; //this is creating instance of 
	
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
		//this is adding object to repo
		custRepo.save(customer);
		return"redirect:/user_register";
	}

}
