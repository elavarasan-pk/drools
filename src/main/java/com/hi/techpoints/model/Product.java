package com.hi.techpoints.model;

public class Product {

	private int productId;
	private String model;
    

	public Product(int productId, String model) {
		super();
		this.productId = productId;
		this.model = model;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}