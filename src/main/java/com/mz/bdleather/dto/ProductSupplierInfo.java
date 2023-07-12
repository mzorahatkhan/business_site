package com.mz.bdleather.dto;

public interface ProductSupplierInfo {
	//its the convention , we need to use get befor the field if we want to use dto(data transfer object)
	public String getProductName();
	public String getSupplierName();
	public String getSupplierCountry();
	

}
