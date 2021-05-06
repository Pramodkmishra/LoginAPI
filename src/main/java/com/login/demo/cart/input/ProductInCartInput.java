package com.login.demo.cart.input;

public class ProductInCartInput {
	private String productId;
	private int quantity;
	public ProductInCartInput(String productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ProductInCartInput() {
		
	}

}
