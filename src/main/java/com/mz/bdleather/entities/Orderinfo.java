package com.mz.bdleather.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Orderinfo {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="order_seq")
	@SequenceGenerator(name="order_seq",sequenceName="order_seq",initialValue=1,allocationSize=1)
	private Long orderId;
	private String item;
	private double itemPrice;
	@Column(name="order_quantity")
	private Long orderQuantity;
	
	//Empty constructor so that we can initialize orders without parameter
	public Orderinfo() {
		
	}
	public Orderinfo(String item, double itemPrice) {
		super();
		this.item = item;
		this.itemPrice = itemPrice;
	}

	public Orderinfo(String item, double itemPrice, Long oderQuantity) {
		super();
		this.item = item;
		this.itemPrice = itemPrice;
		this.orderQuantity = oderQuantity;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice=itemPrice;
	}
	public Long getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(Long orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	
	};
	
	
	


