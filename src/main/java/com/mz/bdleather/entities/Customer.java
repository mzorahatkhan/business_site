package com.mz.bdleather.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_seq")
	@SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", initialValue = 1,allocationSize = 1)
	@Column(name="cust_id")
	private long custId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String email;
	
	@Column(name="user_name")
	private String userName;
	
	private String password;
	
	private String role;
	
	private boolean enabled=true;
	
	public Customer()
	{
		
	}

	public Customer( String firstName, String lastName, String email,
					String userName,String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName=userName;
		this.password=password;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	
	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	};
	
	

}
