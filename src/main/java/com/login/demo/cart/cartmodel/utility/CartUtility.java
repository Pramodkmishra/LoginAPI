package com.login.demo.cart.cartmodel.utility;

import java.util.HashSet;

import com.login.demo.cart.cartmodel.ProductInCart;

public class CartUtility {
	private HashSet<ProductInCart> productInCart;
	private String productId;
	private int quantity;

	public CartUtility(HashSet<ProductInCart> productInCart, String productId) {
		super();
		this.productInCart = productInCart;
		this.productId = productId;
	}

	private int getQuantity() {
		for (ProductInCart pcart : productInCart) {
			if (pcart.getProductId() == productId)
				return pcart.getQuantity();
		}
		return 0;
	}
	public boolean isProductExist()
	{
		for (ProductInCart pcart : productInCart) {
			System.out.println(pcart.getProductId()+" "+productId);
			if (pcart.getProductId().equalsIgnoreCase(productId))
				{quantity=pcart.getQuantity();
				productInCart.remove(pcart);
				return true;}
		}
		return false;
	}

	public int getIncreasedQuantity() {
		return quantity + 1;

	}

	public int getDecreasedQuantity() {
		return getQuantity() - 1;
	}
}
