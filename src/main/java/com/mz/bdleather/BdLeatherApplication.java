package com.mz.bdleather;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mz.bdleather.dao.CustomerRepository;
import com.mz.bdleather.dao.ProductRepository;
import com.mz.bdleather.dao.SupplyRepository;
import com.mz.bdleather.entities.Customer;
import com.mz.bdleather.entities.Product;
import com.mz.bdleather.entities.Supplier;

@SpringBootApplication
public class BdLeatherApplication {
	
	@Autowired
	CustomerRepository custRepo;
	
	@Autowired
	ProductRepository prodRepo;
	
	@Autowired
	SupplyRepository supplyRepo;

	public static void main(String[] args) {
		SpringApplication.run(BdLeatherApplication.class, args);
	}
//	@Bean
//	CommandLineRunner runner()
//	{
//		return args ->{
//			
//			// Seed customer data using constructor from Customer entity
//	        Customer customer1 = new Customer("John", "Doe", "john@example.com");
//	        Customer customer2 = new Customer("Jane", "Smith", "jane@example.com");
//	        Customer customer3 = new Customer("Michael", "Johnson", "michael@example.com");
//	        Customer customer4 = new Customer("Emily", "Brown", "emily@example.com");
//	        Customer customer5 = new Customer("David", "Wilson", "david@example.com");
//
//	        // Seed product data
//	        Product product1 = new Product("Wallet", 29.99, "Leather wallet for men", "Brown");
//	        Product product2 = new Product("Card Holder", 14.99, "Compact card holder", "Black");
//	        Product product3 = new Product("Phone Case", 9.99, "Protective phone case", "Blue");
//	        Product product4 = new Product("Belt", 39.99, "Stylish leather belt", "Black");
//	        Product product5 = new Product("Keychain", 4.99, "Keychain with leather tag", "Brown");
//	     
//	        
//	        Supplier supplier1 = new Supplier("ABC Inc", "USA");
//	        Supplier supplier2 = new Supplier("XYZ LLC", "Canada");
//	        Supplier supplier3 = new Supplier("DEF Corp", "Germany");
//	        Supplier supplier4 = new Supplier("GHI Ltd", "United Kingdom");
//	        Supplier supplier5 = new Supplier("JKL Enterprises", "Australia");
//
//	        // Establish many-to-many relationship between products and suppliers
//	        product1.setSuppliers(Arrays.asList(supplier1));
//	        product2.setSuppliers(Arrays.asList(supplier1, supplier2));
//	        product3.setSuppliers(Arrays.asList(supplier3));
//	        product4.setSuppliers(Arrays.asList(supplier4));
//	        product5.setSuppliers(Arrays.asList(supplier5));
//
//	        supplier1.setProducts(Arrays.asList(product1, product2));
//	        supplier2.setProducts(Arrays.asList(product2));
//	        supplier3.setProducts(Arrays.asList(product3));
//	        supplier4.setProducts(Arrays.asList(product4));
//	        supplier5.setProducts(Arrays.asList(product5));
//
//	     
//	     // Save customers
//	        custRepo.save(customer1);
//	        custRepo.save(customer2);
//	        custRepo.save(customer3);
//	        custRepo.save(customer4);
//	        custRepo.save(customer5);
//	        
//	     // Save products
//	        prodRepo.save(product1);
//	        prodRepo.save(product2);
//	        prodRepo.save(product3);
//	        prodRepo.save(product4);
//	        prodRepo.save(product5);
//	        
//	       // Save suppliers
//	        supplyRepo.save(supplier1);
//	        supplyRepo.save(supplier2);
//	        supplyRepo.save(supplier3);
//	        supplyRepo.save(supplier4);
//	        supplyRepo.save(supplier5);
//
//	        
////		};
//	}
	
	

}
