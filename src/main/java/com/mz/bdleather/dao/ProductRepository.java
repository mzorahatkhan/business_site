package com.mz.bdleather.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mz.bdleather.dto.PieChartProduct;
import com.mz.bdleather.dto.ProductSupplierInfo;
import com.mz.bdleather.entities.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {
    @Override
	public List<Product> findAll();
    
    //custom query to find product name , supplier name and theier country 
    @Query(nativeQuery=true,value="SELECT p.PROD_NAME AS productName, s.SUPPLIER_NAME AS supplierName, s.SUPPLIER_COUNTRY AS supplierCountry "
    		+ "FROM PRODUCT_SUPPLIER ps "
    		+ "JOIN PRODUCT p ON ps.PRODUCT_ID = p.PRODUCT_ID "
    		+ "JOIN SUPPLIER s ON ps.SUPPLIER_ID = s.SUPPLIER_ID")
    public List<ProductSupplierInfo>showProductWithSupplier(); //created a method accepts a List with type ProductSupplierInfo interface as dto
    
    //Custom query to show number of different colored products 
    @Query(nativeQuery=true,value="SELECT prod_color as label, COUNT(*) AS productCount FROM product GROUP BY prod_color")
    public List<PieChartProduct> showProductNumberWithDifferentColor();
}
