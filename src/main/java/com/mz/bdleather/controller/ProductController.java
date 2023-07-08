package com.mz.bdleather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mz.bdleather.dao.ProdInventoryRepository;
import com.mz.bdleather.dao.ProductRepository;
import com.mz.bdleather.entities.ProdInventory;
import com.mz.bdleather.entities.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository prodRepo;
	@Autowired
	ProdInventoryRepository prodInvRepo;
	
	@GetMapping("/new")
	public String displayProductForm(Model model) 
	{
		Product aProduct=new Product();
		model.addAttribute("products",aProduct);
		return"product/new-products";
	}
	@PostMapping("/create")
	public String createNewProduct(Product product, Model model)
	{
		prodRepo.save(product);
		return"redirect:/products/new";
	}
    
	//this is the endpoint for inserting supplier information and binding the form
	@GetMapping("/prod_inventory")
	public String displayProductInventoryForm(Model model)
	{
		ProdInventory prodInventory=new ProdInventory();
		model.addAttribute("prodInventory", prodInventory);
		return"product/prod-inventory";
	}
	//this to save the binding form field to the database using ProdInventoryRepo
	@PostMapping("/suppliers")
	public String submitProducInventoryForm(Model model,ProdInventory prodInventory)
	{
		prodInvRepo.save(prodInventory);
		return"redirect:/products/prod_inventory";
	}
}
