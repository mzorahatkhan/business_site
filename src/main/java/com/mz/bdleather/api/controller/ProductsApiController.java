package com.mz.bdleather.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	//Api endpoint to get a product by product id 
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long id)
	{
		return prodService.getById(id);
	}
	//Post api endpoint to create a product
	@PostMapping(consumes="Application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Product createnewProduct(@RequestBody Product product)
	{
		return prodService.save(product);
	}

	
	//endpoint to update a product using product id
	@PutMapping(consumes="Application/json")
	@ResponseStatus(HttpStatus.OK)
	public Product updateProduct(@RequestBody Product prodcuts)
	{
		return prodService.save(prodcuts);
	}
	
	//endpoint to partial updat of product by given id
	
	@PatchMapping(path="/{id}",consumes="Application/json")
	@ResponseStatus(HttpStatus.OK)
	public Product partialUpdateById(@PathVariable("id") Long id,@RequestBody Product product)
	{
		Product prod=prodService.getById(id);
		
		if (product.getProdName()!= null)
		{
			prod.setProdName(product.getProdName());
			
		}
		if (product.getProdColor()!=null)
		{
			prod.setProdColor(product.getProdColor());
		}
		
		if(product.getProdDescription()!=null)
		{
			prod.setProdDescription(product.getProdDescription());
		}
		if(product.getProdPrice()!=0)
		{
			prod.setProdPrice(product.getProdPrice());
		}
		return prodService.save(prod);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id)
	{
		prodService.deleteById(id);
	}
	
}
