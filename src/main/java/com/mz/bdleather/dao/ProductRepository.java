package com.mz.bdleather.dao;

import org.springframework.data.repository.CrudRepository;

import com.mz.bdleather.entities.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {

}
