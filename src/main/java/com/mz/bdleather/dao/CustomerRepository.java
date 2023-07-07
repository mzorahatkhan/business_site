package com.mz.bdleather.dao;

import org.springframework.data.repository.CrudRepository;

import com.mz.bdleather.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Long>{
	//this is an interface and use as data access object

}
