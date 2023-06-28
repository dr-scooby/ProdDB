package com.jah.demo.ProductSpringDemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Dr.Scooby
 *
 */

@Component
public class ProductService {
	
	List<Product> products = new ArrayList<>();
	
	@Autowired
	ProdDBI db ;
	
	
	public void show() {
		System.out.println("in show");
	}
	
	public List<Product> getAllProducts(){
		return db.findAll();
	}
	
//	public ProductService() {
//		db = new ProductDB();
//	}
//	
//	public void addProduct(Product p) {
//		
//		db.add(p);
//	}
//	
//	
//	public List<Product> getAll(){
//		return db.getAll();
//	}
//	
//	public List<Product> getProduct(String search){
//		return db.getProduct(search);
//	}

}
