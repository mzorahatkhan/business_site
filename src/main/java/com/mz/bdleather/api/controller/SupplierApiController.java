package com.mz.bdleather.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mz.bdleather.entities.Supplier;
import com.mz.bdleather.services.SupplierService;

@RestController
@RequestMapping("/app-api/supplier")
public class SupplierApiController {
	
	@Autowired 
	SupplierService suppService;
	
	//Endpoingt to get all supplier 
	
	@GetMapping
	public List<Supplier> getAllSupplier()
	{
		return suppService.getAll();
	}

	//endpoint to get a supplier by id
	@GetMapping("/{id}")
	public Supplier getSupplierById(@PathVariable("id") Long id)
	{
		return suppService.findSupplierById(id);
	}
	
	//endpoint to create new supplier 
	@PostMapping (consumes="Application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Supplier createSupplier(@RequestBody Supplier supplier)
	{
		return suppService.save(supplier);
	}
	//endpont to update a supplier by supplier id 
	@PutMapping(consumes="Application/json")
	@ResponseStatus(HttpStatus.OK)
	public Supplier updateSupplier(@RequestBody Supplier supplier)
	{
		return suppService.save(supplier);
	}
	
	//endpoint for partial update of supplier 
	@PatchMapping(path="/{id}",consumes="Application/json")
	@ResponseStatus(HttpStatus.OK)
	public Supplier partialUpdateSupplier(@PathVariable("id") Long id,@RequestBody Supplier supplier)
	{
		Supplier supp=suppService.findSupplierById(id);
		
		if (supplier.getSupplierName()!=null)
		{
			supp.setSupplierName(supplier.getSupplierName());
		}
		if (supplier.getSupplierCountry()!=null)
		{
			supp.setSupplierCountry(supplier.getSupplierCountry());
		}
		
		return suppService.save(supp);
	}
	
	//endpoint to delete a supplier 
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteSupplierById(@PathVariable("id") Long id)
	{
		suppService.deleteSupplierById(id);
	}
}
