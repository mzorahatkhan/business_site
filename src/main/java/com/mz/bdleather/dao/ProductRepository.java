package com.mz.bdleather.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mz.bdleather.entities.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {
    @Override
	public List<Product> findAll();
}
