package com.exception.dto;

import org.springframework.stereotype.Component;

@Component
public class ProductLoaderOutDto {

	private int id;

	private String store;

	private String productBarCode;

	private double price;

	private String notes;

	private double avgPrice;

	private double lowestPrice;

	private double hightPrice;

	private double idealPrice;

	private long pricesCollected;

	private String description;

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

	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double i) {
		this.avgPrice = i;
	}

	public double getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	public double getHightPrice() {
		return hightPrice;
	}

	public void setHightPrice(double hightPrice) {
		this.hightPrice = hightPrice;
	}

	public double getIdealPrice() {
		return idealPrice;
	}

	public void setIdealPrice(double idealPrice) {
		this.idealPrice = idealPrice;
	}

	public long getPricesCollected() {
		return pricesCollected;
	}

	public void setPricesCollected(long pricesCollected) {
		this.pricesCollected = pricesCollected;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductLoaderOutDto [id=" + id + ", store=" + store + ", productBarCode=" + productBarCode + ", price="
				+ price + ", notes=" + notes + ", avgPrice=" + avgPrice + ", lowestPrice=" + lowestPrice
				+ ", hightPrice=" + hightPrice + ", idealPrice=" + idealPrice + ", pricesCollected=" + pricesCollected
				+ ", description=" + description + "]";
	}

}
