package com.mz.bdleather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mz.bdleather.dao.CustomerRepository;
import com.mz.bdleather.dao.ProductRepository;
import com.mz.bdleather.dao.SupplyRepository;
import com.mz.bdleather.dto.PieChartProduct;
import com.mz.bdleather.dto.ProductSupplierInfo;
import com.mz.bdleather.entities.Customer;
import com.mz.bdleather.entities.Product;
import com.mz.bdleather.entities.Supplier;

@Controller
@RequestMapping("")
public class HomeController {
	@Autowired
	ProductRepository prodRepo;//bringing prodrepo to run crud operation prom h2 database
	@Autowired
	CustomerRepository custRepo; //autowiring customer repository instance for curd operation.
	
	@Autowired
	SupplyRepository supplyRepo;
	
	@Value("${myVersion}")
	public String ver;
	
	
	//this endpoint will show the home page
	@GetMapping("")
	public String displayHome()
	{
		return"main/index";
	}
	//this endpoint will show the home page with /home endpoint
		@GetMapping("/home")
		public String displayHomeWithEndpoin(Model model)
		{
			model.addAttribute("versionNumber", ver);
			return"main/index";
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
	
	@GetMapping("/insert_product")
	public String insertProduct()
	{
		return"redirect:/products/new";
	}
	
	//this endpoint will show the product details in database
	@GetMapping("/displayProducts")
	public String displayProducts(Model model) throws JsonProcessingException
	{
		List<Product> products=prodRepo.findAll();//declaring list of product to store prodRepo curd operation.
		model.addAttribute("productsList", products);// adding the object to model using key value pair.
		//using prodRepo to store the value comes from a custom query which type is a  list of dto this case ProductSupplierInfo
		List<ProductSupplierInfo>prodSupplierInfo=prodRepo.showProductWithSupplier();
		//adding list objec comes from custom query to the model
		model.addAttribute("prodSupplyInfo", prodSupplierInfo);
		
		//using prodrepo to store the values comes from a customr query and which type is List of PieChartProduct
		List<PieChartProduct>pieChartProductData=prodRepo.showProductNumberWithDifferentColor();
		
		//need to transform this list to a json object we need ObjectMapper
		ObjectMapper objectMapper= new ObjectMapper();
		//using objectMapper we can transfor our list data to json.
		String jsonStringProduct=objectMapper.writeValueAsString(pieChartProductData);
		//now our json data is ready and we need add this to our model
		model.addAttribute("dataForChart", jsonStringProduct);
		return"main/display-product"; //this is for displaying products
	}
	
	//this endpoint will show the all the customer details are present in database
	@GetMapping("/displayCustomers")
	public String displayCustomers(Model model)
	{
		List<Customer> customers=custRepo.findAll();
		model.addAttribute("customerList", customers);
		return "main/display-customer";
	}
	
	@GetMapping("/displaySupplier")
	public String displaySupplierInfo(Model model)
	{
		List<Supplier>supplier=supplyRepo.findAll();
		model.addAttribute("supplierList", supplier);
		return"main/display-supply";
	}
}
