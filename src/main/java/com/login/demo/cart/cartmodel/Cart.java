package com.login.demo.cart.cartmodel;

import java.util.HashSet;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Cart")
public class Cart {
	@Indexed(name="customerId",unique=true)
	private String customerId;
	private HashSet<ProductInCart> productInCart;
	public Cart(String customerId, HashSet<ProductInCart> productInCart) {
		super();
		this.customerId = customerId;
		this.productInCart = productInCart;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public HashSet<ProductInCart> getProductInCart() {
		return productInCart;
	}
	public void setProductInCart(HashSet<ProductInCart> productInCart) {
		this.productInCart = productInCart;
	}
	@Override
	public String toString() {
		return "Cart [customerId=" + customerId + ", productInCart=" + productInCart + "]";
	}
	public void printData()
	{
		System.out.println(customerId);
		for(ProductInCart p:productInCart)
			System.out.println(p.toString());
	}
			
}
