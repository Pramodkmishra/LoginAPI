package com.login.demo.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.login.demo.model.Customer;
import com.login.demo.repository.CustomerRepository;

@Component
public class CustomerResolver implements GraphQLQueryResolver {
	@Autowired()
	CustomerRepository custrepo;
	public Optional<Customer> customer(String id) {
		return custrepo.findById(id);
	
	}
	public Optional<Customer> customerFindByEmail(String email)
	{
		return custrepo.findByEmail(email);
	}
public Iterable<Customer> findAllCustomers()
{
	return custrepo.findAll();
	}

}
