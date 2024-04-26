package com.hema.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product 
{
	@Id
	private int id;
	private String product_name;
	private int product_price;
	
	public Product () {}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name + ", product_price=" + product_price + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public int getProduct_price() {
		return product_price;
	}


	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}


	public Product(int id, String product_name, int product_price) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.product_price = product_price;
	}
	
	
	
	
	

}
