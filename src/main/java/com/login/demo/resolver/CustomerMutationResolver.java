package com.login.demo.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.login.demo.model.Customer;
import com.login.demo.model.input.CustomerInput;
import com.login.demo.repository.CustomerRepository;

@Component
public class CustomerMutationResolver  implements GraphQLMutationResolver {
	@Autowired
	CustomerRepository custrepo;
	public Customer createCustomer(String id,String firstName,String lastName,String email,String phone,String city,String country,String password1,String password2)
	{
		Customer customer =new Customer(/*id,*/firstName,lastName,email,phone,city,country,password1,password2);
		custrepo.save(customer);
		return customer;
	}
	
	public Customer makeCustomer(CustomerInput input)
	{
		Customer customer =new Customer(/*input.getId(),*/input.getFirstName(),input.getLastName(),input.getEmail(),input.getPhone(),input.getCity(),input.getCountry(),input.getPassword1(),input.getPassword2());
		custrepo.save(customer);
		return customer;
	}
	
	public boolean deleteCustomer(String id)
	{
	custrepo.deleteById(id);
	return true;
	}
public Customer updateCustomer(String id,String firstName,String lastName,String email,String city,String country,String password1,String password2)
throws Exception{
	Optional<Customer> optCustomer=custrepo.findById(id);
	if(optCustomer.isPresent()) {
		Customer customer=optCustomer.get();
	if (firstName!=null)
	customer.setFirstName(firstName);
	custrepo.save(customer);
		
return customer;	}
	throw new Exception("Not found Customer to update!");
}
}
