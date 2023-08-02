package com.mz.bdleather.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;



@Entity
public class Product {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="product_seq")
	@SequenceGenerator(name = "product_seq", sequenceName = "product_seq", initialValue = 1000,allocationSize = 1)
	private long productId;
	private String prodName;
	private double prodPrice;
	private String prodDescription;
	private String prodColor;
	@Column(name="prodimage")
	
	private byte[] prodImage;
	
	@ManyToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},
			fetch=FetchType.LAZY)
	@JoinTable(name="product_supplier",
	           joinColumns=@JoinColumn(name="product_id"),
	           inverseJoinColumns=@JoinColumn(name="supplier_id"))
	@JsonIgnore
	private List<Supplier> suppliers;
	
	public Product() {
		
	};
	
	//this constructor is created so that user can intantiate the product object without prodImage
	public Product(String prodName, double prodPrice, String prodDescription,String prodColor) {
		super();
		this.prodColor=prodColor;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodDescription = prodDescription;
		
	}
	//this constructor is created so that user can intantiate the product object with prodImage if they want 
	public Product(String prodName, double prodPrice, String prodDescription,String prodColor,byte[] prodImage) {
		super();
		this.prodColor=prodColor;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodDescription = prodDescription;
		this.prodImage=prodImage;
	}
	
	
	
	public List<Supplier> getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
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
	public byte[] getProdImage() {
		return prodImage;
	}
	public void setProdImage(byte[] prodImage) {
		this.prodImage = prodImage;
	}
	
	
}
