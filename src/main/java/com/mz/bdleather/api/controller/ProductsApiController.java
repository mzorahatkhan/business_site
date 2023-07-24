package com.mz.bdleather.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mz.bdleather.entities.Product;
import com.mz.bdleather.services.ProductService;

@RestController
@RequestMapping("/app-api/product")
public class ProductsApiController {
	@Autowired
	ProductService prodService;
	
	//api endpoint to get all the products
	@GetMapping
	public List<Product> getAllProdcut()
	{
		return prodService.getAll();
		
	}
	
	

}
