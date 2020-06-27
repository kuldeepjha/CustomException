package com.exception.dto;

import org.springframework.stereotype.Component;

@Component
public class ProductLoaderInDto {

	private int id;

	private String store;

	private String productBarCode;
	
	private double price;
	
	private String notes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getProductBarCode() {
		return productBarCode;
	}

	public void setProductBarCode(String productBarCode) {
		this.productBarCode = productBarCode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "ProductLoaderInDto [id=" + id + ", store=" + store + ", productBarCode=" + productBarCode + ", price="
				+ price + ", notes=" + notes + "]";
	}
	
}
