package com.mz.bdleather.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mz.bdleather.dao.CustomerRepository;
import com.mz.bdleather.entities.Customer;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository custRepo;
	
	///defining method using CustRepo to save 
	public Customer save(Customer customer) {
		return custRepo.save(customer);
	}

	
	public List<Customer>getAll(){
		return custRepo.findAll();
	}
	
	
}
