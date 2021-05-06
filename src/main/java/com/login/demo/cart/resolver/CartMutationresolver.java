
package com.login.demo.cart.resolver;

import java.util.HashSet;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.login.demo.cart.cartmodel.Cart;
import com.login.demo.cart.cartmodel.ProductInCart;
import com.login.demo.cart.cartmodel.utility.CartUtility;
import com.login.demo.cart.cartrepository.CartRepository;
import com.login.demo.cart.input.ProductInCartInput;

@Component
public class CartMutationresolver implements GraphQLMutationResolver {
	@Autowired
	CartRepository cartRepo;
	CartUtility cartUtility;
	Cart cart;
	
	public Cart emptyCart(String customerId)
	{
		cartRepo.deleteByCustomerId(customerId);
		return null;
	}
	public Cart removeFromCart(String customerId,String productId)
	{
		Cart cartById = cartRepo.findByCustomerId(customerId);
		HashSet<ProductInCart> set = new HashSet<ProductInCart>();
		
		if(cartById.getProductInCart().size()==1) {
			cartRepo.deleteByCustomerId(customerId);
			return null;
		}
		
		set.addAll(cartById.getProductInCart());
		cartUtility=new CartUtility(set,productId);
		cartUtility.isProductExist();
		cartRepo.deleteByCustomerId(customerId);
		cart = new Cart(customerId, set);
		cartRepo.save(cart);
		return cart;
		
	}

	public Cart createCart(String customerId, ProductInCartInput productInCartInput) {
		HashSet<ProductInCart> set = new HashSet<ProductInCart>();
		
		ProductInCart productInCart = new ProductInCart();
		try {
			BeanUtils.copyProperties(productInCart, productInCartInput);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Cart cartById = cartRepo.findByCustomerId(customerId);
		if (cartById == null) {
			set.add(productInCart);

			cart = new Cart(customerId, set);
			System.out.println("Empty");
			cartRepo.save(cart);
			return cart;
		} else

		{
			set.addAll(cartById.getProductInCart());
			cartUtility=new CartUtility(set,productInCart.getProductId());
			if(cartUtility.isProductExist()) {
				System.out.print(cartUtility.getIncreasedQuantity());
				
				productInCart.setQuantity(cartUtility.getIncreasedQuantity());
				set.add(productInCart);
				
			cartRepo.deleteByCustomerId(customerId);
			cart = new Cart(customerId, set);
			System.out.println("duplicate");
			cartRepo.save(cart);
			return cart;
			}
			else
			{
				set.add(productInCart);
				cartRepo.deleteByCustomerId(customerId);
				cart = new Cart(customerId, set);
				System.out.println("unique");
				cartRepo.save(cart);
				return cart;
				
				
			}
			}
		
	}

}
