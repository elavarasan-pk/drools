package com.hi.techpoints.model;

public class Product {

	private String model;
	private int discount;
	private String buyer;
	
	public Product(String model, int discount, String buyer) {
		super();
		this.model = model;
		this.discount = discount;
		this.buyer = buyer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	
}