package com.mz.bdleather.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Product {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long productId;
	private String prodName;
	private double prodPrice;
	private String prodDescription;
	private String prodColor;
	@OneToMany(mappedBy="theProduct")
	private List<Supplier> supplier;
	
	public Product() {
		
	};
	public Product(String prodName, double prodPrice, String prodDescription,String prodColor) {
		super();
		this.prodColor=prodColor;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodDescription = prodDescription;
	}
	
	
	public List<Supplier> getSupplier() {
		return supplier;
	}
	public void setSupplier(List<Supplier> supplier) {
		this.supplier = supplier;
	}
	public long getProductId() {
		return productId;
	}
	
	public String getProdColor() {
		return prodColor;
	}
	public void setProdColor(String prodColor) {
		this.prodColor = prodColor;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public double getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdDescription() {
		return prodDescription;
	}
	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}
	
}
