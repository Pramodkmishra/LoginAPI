package com.login.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.login.demo.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer,String> {
	public Optional<Customer> findById(String id);
	public Optional<Customer> findByEmail(String email);

}
