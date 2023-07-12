package com.mz.bdleather.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mz.bdleather.dto.ProductSupplierInfo;
import com.mz.bdleather.entities.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {
    @Override
	public List<Product> findAll();
    
    @Query(nativeQuery=true,value="SELECT p.PROD_NAME AS productName, s.SUPPLIER_NAME AS supplierName, s.SUPPLIER_COUNTRY AS supplierCountry "
    		+ "FROM PRODUCT_SUPPLIER ps "
    		+ "JOIN PRODUCT p ON ps.PRODUCT_ID = p.PRODUCT_ID "
    		+ "JOIN SUPPLIER s ON ps.SUPPLIER_ID = s.SUPPLIER_ID")
    public List<ProductSupplierInfo>showProductWithSupplier();
}
