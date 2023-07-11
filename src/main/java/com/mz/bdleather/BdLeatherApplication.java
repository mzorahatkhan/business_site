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
	
	

}
