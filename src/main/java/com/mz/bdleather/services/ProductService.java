package com.mz.bdleather.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mz.bdleather.dao.ProductRepository;
import com.mz.bdleather.dto.PieChartProduct;
import com.mz.bdleather.dto.ProductSupplierInfo;
import com.mz.bdleather.entities.Product;

@Service
public class ProductService {
	@Autowired
	ProductRepository prodRepo;
	
	//defining method using prodrepo wher we can using prodService instead of prodRepo
	public Product save(Product product) {
		return prodRepo.save(product);
	}
	
	public List<Product>getAll(){
		return prodRepo.findAll();
	}
   
	public Product getById(Long Id){
		return prodRepo.findById(Id).get();
	}
	public void deleteById(Long Id) {
		prodRepo.deleteById(Id);
		
	}
	public List<ProductSupplierInfo>getProductWithSupplier(){
		return prodRepo.showProductWithSupplier();
	}
	public List<PieChartProduct> getProductNumberWithDifferentColor(){
		return prodRepo.showProductNumberWithDifferentColor();
	}
}
