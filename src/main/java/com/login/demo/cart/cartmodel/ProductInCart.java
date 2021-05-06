package com.login.demo.cart.cartmodel;


public class ProductInCart {
	private String productId;
	private int quantity;
	
	public ProductInCart()
	{}
	public ProductInCart(String productId, int quantity) {
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
	@Override
	public String toString() {
		return "ProductInCart [productId=" + productId + ", quantity=" + quantity + "]";
	}
	

}
