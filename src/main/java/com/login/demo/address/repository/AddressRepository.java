package com.login.demo.address.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.login.demo.address.CustomerAddress;

public interface AddressRepository extends MongoRepository<CustomerAddress,String>{
	CustomerAddress findByCustomerId(String customerId);

}
