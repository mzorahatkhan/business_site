package com.mz.bdleather.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mz.bdleather.dao.ProductRepository;
import com.mz.bdleather.entities.Customer;
import com.mz.bdleather.entities.Product;

@Controller
@RequestMapping("")
public class HomeController {
	@Autowired
	ProductRepository prodRepo;//bringing prodrepo to run crud operation prom h2 database
	
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
    //after clicking login in home-page ,its re-direct to /loginForm in loginController
	@GetMapping("/login")
	public String showLoginPage()
	{
		return"redirect:/customer/loginForm";
	}
	
	//this is the post mapping where after clicking login ,its redirected to this method 
	@PostMapping("/customer_login")
	public String returnToHomePage()
	{
		return"redirect:/";
	}
	
	//this endpoint will show the product details in database
	@GetMapping("/displayProducts")
	public String displayProducts(Model model)
	{
		List<Product> products=prodRepo.findAll();//declaring list of product to store prodRepo curd operation.
		model.addAttribute("productsList", products);// adding the object to model using key value pair.
		return"display-product"; //this is for displaying products
	}
	
	
}
