package com.mz.bdleather.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProdInventory {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long supplierId;
	
	private String supplierName;
	private String supplierCountry;
	public ProdInventory()
	{
		
	}
	public ProdInventory(String supplierName, String supplierCountry) {
		super();
		this.supplierName = supplierName;
		this.supplierCountry = supplierCountry;
	}
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierCountry() {
		return supplierCountry;
	}
	public void setSupplierCountry(String supplierCountry) {
		this.supplierCountry = supplierCountry;
	};
	
	
	

}
