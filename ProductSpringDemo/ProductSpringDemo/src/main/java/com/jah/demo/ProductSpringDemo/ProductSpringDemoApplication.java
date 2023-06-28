package com.jah.demo.ProductSpringDemo;

import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductSpringDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =   SpringApplication.run(ProductSpringDemoApplication.class, args);
		
		ProductService ps = context.getBean(ProductService.class);
		ps.show();
		List<Product> prods = ps.getAllProducts();
		for( Product p : prods) {
			System.out.println(p);
		}
	}

}
