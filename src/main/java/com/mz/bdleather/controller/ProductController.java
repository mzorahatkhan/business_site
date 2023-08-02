package com.mz.bdleather.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mz.bdleather.dao.OrderRepository;
import com.mz.bdleather.entities.Orderinfo;
import com.mz.bdleather.entities.Product;
import com.mz.bdleather.entities.Supplier;
import com.mz.bdleather.services.ProductService;
import com.mz.bdleather.services.SupplierService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService prodService;
	@Autowired
	SupplierService suppService;
	@Autowired
	OrderRepository orderRepo;
	
	@GetMapping("/new")
	public String displayProductForm(Model model) 
	{
		Product aProduct=new Product();
		List<Supplier>suppliers=suppService.getAll();
		model.addAttribute("products",aProduct);
		model.addAttribute("supplierList", suppliers);
		return"product/new-products";
	}
	@PostMapping("/create")
	public String createNewProduct(@RequestParam("file") MultipartFile file, Product product, Model model)
	{
	    try {
	        // Check if the file is not empty
	        if (!file.isEmpty()) {
	            // Get the byte array of the file's content
	            byte[] imageBytes = file.getBytes();

	            // Set the image data to the product
	            product.setProdImage(imageBytes);
	        }

	        // Save the product to the database
	        prodService.save(product);

	        
	    } 
	    
	    catch (IOException e) {
	        // Handle the exception...
	    }
	    return "redirect:/product/new";
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
		suppService.save(supplier);
		return"redirect:/product/supply_info";
	}
	
	//Endpoint to get the product image by productId
	@GetMapping("/image/{productId}")
	public ResponseEntity<byte[]> getProductImage(@PathVariable long productId)
	{
	    Product product = prodService.getById(productId);
	    if (product != null && product.getProdImage() != null) {
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.IMAGE_PNG); // Change MediaType according to your image type
	        return new ResponseEntity<>(product.getProdImage(), headers, HttpStatus.OK);
	    } else {
	        // Return a default image or an error response if the image is not found
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	 }
	
    
	  //Endpoint to get the product details using product id 
	    @GetMapping("/{productId}")
	    public String showProductDetailsByid(@PathVariable("productId") long productId, Model model)
	    {
	    	Product product=prodService.getById(productId);
	    	model.addAttribute("products",product);
	    	
	    	return"product/display-single-product";
	    }
	    
	    
	    
	    //Endpoint to view the cart 
	    @PostMapping("/addToCart/{productId}")
	    public String  addItemToCart(@PathVariable("productId") long productId,Model model, Orderinfo orderinfo)
	    {
	    	Product product=prodService.getById(productId);
	    	model.addAttribute("products",product);
	    	orderinfo.setItem(product.getProdName());
	    	orderinfo.setItemPrice(product.getProdPrice());
	    	orderRepo.save(orderinfo);
	    	
	    	//Add a success message to be displayed on the redirected page
	        model.addAttribute("message", "Item added to cart successfully!");
	        
	    	return"redirect:/product/{productId}";
	    	
	    }
	 

}
