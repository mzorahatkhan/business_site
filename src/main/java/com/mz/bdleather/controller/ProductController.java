package com.mz.bdleather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mz.bdleather.dao.SupplyRepository;
import com.mz.bdleather.dao.ProductRepository;
import com.mz.bdleather.entities.Supplier;
import com.mz.bdleather.entities.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository prodRepo;
	@Autowired
	SupplyRepository supplyRepo;
	
	@GetMapping("/new")
	public String displayProductForm(Model model) 
	{
		Product aProduct=new Product();
		List<Supplier>supplier=supplyRepo.findAll();
		model.addAttribute("products",aProduct);
		model.addAttribute("supplierList", supplier);
		return"product/new-products";
	}
	@PostMapping("/create")
	public String createNewProduct(Product product, Model model)
	{
		prodRepo.save(product);
		return"redirect:/products/new";
	}
    
	//this is the endpoint for inserting supplier information and binding the form
	@GetMapping("/supply_info")
	public String displaySupplyInfoForm(Model model)
	{
		Supplier supplier=new Supplier();
		model.addAttribute("supplier", supplier);
		return"product/supply-info";
	}
	//this to save the binding form field to the database using ProdInventoryRepo
	@PostMapping("/suppliers")
	public String submitProducInventoryForm(Model model,Supplier supplier)
	{
		supplyRepo.save(supplier);
		return"redirect:/products/supply_info";
	}
}
