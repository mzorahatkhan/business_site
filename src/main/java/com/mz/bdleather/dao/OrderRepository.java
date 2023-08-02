package com.mz.bdleather.dao;

import org.springframework.data.repository.CrudRepository;

import com.mz.bdleather.entities.Orderinfo;

public interface OrderRepository extends CrudRepository<Orderinfo,Long>{
	

}
