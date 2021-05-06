package com.login.demo.cart.cartrepository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.login.demo.cart.cartmodel.Cart;

public interface CartRepository extends MongoRepository<Cart,String> {
	public Cart findByCustomerId(String customerId);
	public void deleteByCustomerId(String customerId); 

}
