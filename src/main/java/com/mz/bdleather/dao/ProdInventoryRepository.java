package com.mz.bdleather.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mz.bdleather.entities.ProdInventory;

public interface ProdInventoryRepository extends CrudRepository<ProdInventory,Long> {
 
	@Override
	public List<ProdInventory>findAll();
}
