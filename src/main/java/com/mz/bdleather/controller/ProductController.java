package com.mz.bdleather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mz.bdleather.dao.ProductRepository;
import com.mz.bdleather.entities.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository prodRepo;
	
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

}
