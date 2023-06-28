package com.jah.demo.ProductSpringDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Class to handle DB connection and DB processing
 * 
 * @author Dr. Scooby
 *
 */
public class ProductDB {
	
	
	private Connection conn = null;
	
	private static final String DBNAME = "Skyhawk";
	private String dburl = "jdbc:mysql://194.168.2.69:3306/"+DBNAME;
	private String dbuser = "nurali";
	private String dbpass = "java1973";

	
	
	
	public ProductDB() {
		System.out.println("starting DB...");
		try {
			conn = DriverManager.getConnection(dburl, dbuser, dbpass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// add Product to database
	public void add(Product p) {
		System.out.println("add to DB called, attempting to add...");
		String query = "insert into product (name, type, place, warranty) values(?,?,?,?)";
		
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, p.getName());
			st.setString(2, p.getType());
			st.setString(3, p.getPlace());
			st.setInt(4, p.getWarranty());
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// get listing of all products
	public List<Product> getAll(){
		List<Product> products = new ArrayList<>();
		
		System.out.println("getAll to DB called, attempting to get...");
		String query = "select * from product";
		
		try {
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setType(rs.getString(3));
				p.setPlace(rs.getString(4));
				p.setWarranty(rs.getInt(5));
				products.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}
	
	// get a product, search
	public List<Product> getProduct(String name){
		List<Product> products = new ArrayList<>();
		
		System.out.println("get A product to DB called, attempting to get...");
		String query = "select * from product where name like ? or type like ?";
		
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, "%" + name + "%");
			st.setString(2, "%" + name + "%");
			
			// want to use the like with the %:
			//ps.setString(1, "%" + searchserial + "%");
			
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setType(rs.getString(3));
				p.setPlace(rs.getString(4));
				p.setWarranty(rs.getInt(5));
				products.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}

}
