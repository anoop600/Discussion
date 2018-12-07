package com.mindtree.discussion.entity;

public class Product {
	private int slNo;
	private String product;
	private double price;
	private String type;

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Product [slNo=" + slNo + ", product=" + product + ", price=" + price + ", type=" + type + "]";
	}

	
}
