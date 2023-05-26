package com.hi.techpoints.model;

public class Product {

	private String model;
	private int discount;
	private String event;
	
	public Product(String model, int discount, String event) {
		super();
		this.model = model;
		this.discount = discount;
		this.event = event;
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

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
	
}