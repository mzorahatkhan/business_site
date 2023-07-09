package com.mz.bdleather.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mz.bdleather.entities.Supplier;

public interface SupplyRepository extends CrudRepository<Supplier,Long> {
 
	@Override
	public List<Supplier>findAll();
}
