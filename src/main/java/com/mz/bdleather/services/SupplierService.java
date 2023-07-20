package com.mz.bdleather.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mz.bdleather.dao.SupplyRepository;
import com.mz.bdleather.entities.Supplier;

@Service
public class SupplierService {
	
	@Autowired
	SupplyRepository suppRepo;
	
	public Supplier save(Supplier supplier) {
		return suppRepo.save(supplier);
	}

	public List<Supplier> getAll(){
		return suppRepo.findAll();
	}
	
}
