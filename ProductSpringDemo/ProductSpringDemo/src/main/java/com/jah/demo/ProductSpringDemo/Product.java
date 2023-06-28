package com.jah.demo.ProductSpringDemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @author nurali
 *
 */

@Entity
public class Product {
	
	//name, type, place, warranty
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String type;
	private String place;
	private int warranty;
	
	
	public Product() {
		id = 0;
		name= "";
		type= "";
		place= "";
		warranty = 0;
	}
	
	public Product(String name, String type, String place, int warranty) {
		super();
		
		this.name = name;
		this.type = type;
		this.place = place;
		this.warranty = warranty;
	}
	
	public Product(int id, String name, String type, String place, int warranty) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.place = place;
		this.warranty = warranty;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return the warranty
	 */
	public int getWarranty() {
		return warranty;
	}

	/**
	 * @param warranty the warranty to set
	 */
	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", place=" + place + ", warranty=" + warranty
				+ "]";
	}
	
	
	

}
