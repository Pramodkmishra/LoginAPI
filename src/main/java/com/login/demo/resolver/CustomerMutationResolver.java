package com.login.demo.resolver;

import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.login.demo.model.Customer;
import com.login.demo.model.input.CustomerInput;
import com.login.demo.repository.CustomerRepository;

@Component
public class CustomerMutationResolver implements GraphQLMutationResolver {
	@Autowired
	CustomerRepository custrepo;

	public Customer createCustomer(CustomerInput input) {

		Customer customer = new Customer();
		try {
			BeanUtils.copyProperties(customer, input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		custrepo.save(customer);
		return customer;
	}

	public boolean deleteCustomer(String id) {
		custrepo.deleteById(id);
		return true;
	}

	public Customer updateCustomer(String id, String firstName, String lastName, String email, String city,
			String country, String password1, String password2) throws Exception {
		Optional<Customer> optCustomer = custrepo.findById(id);
		if (optCustomer.isPresent()) {
			Customer customer = optCustomer.get();
			if (firstName != null)
				customer.setFirstName(firstName);
			custrepo.save(customer);

			return customer;
		}
		throw new Exception("Not found Customer to update!");
	}

	public Customer updateCust(String id, CustomerInput input) throws Exception {

		Optional<Customer> optCustomer = custrepo.findById(id);
		if (optCustomer.isPresent()) {
			Customer customer = optCustomer.get();
			try {
				BeanUtils.copyProperties(customer, input);
			} catch (Exception e) {
				e.printStackTrace();
			}

			custrepo.save(customer);

			return customer;
		}
		throw new Exception("Not found Customer to update!");

	}
}
