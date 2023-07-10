package com.mz.bdleather.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long supplierId;
	
	private String supplierName;
	private String supplierCountry;
	
	@ManyToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},
			fetch=FetchType.LAZY)
	@JoinTable(name="product_supplier",
    joinColumns=@JoinColumn(name="supplier_id"),
    inverseJoinColumns=@JoinColumn(name="product_id"))
	private List<Product> prducts;
	
	public List<Product> getPrducts() {
		return prducts;
	}
	public void setPrducts(List<Product> prducts) {
		this.prducts = prducts;
	}
	public Supplier()
	{
		
	}
	public Supplier(String supplierName, String supplierCountry) {
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
