package com.login.demo.address.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.login.demo.address.CustomerAddress;
import com.login.demo.address.model.Address;
import com.login.demo.address.repository.AddressRepository;
@Component
public class AddressQueryResolver implements GraphQLQueryResolver{
	@Autowired
	AddressRepository addressRepository;
	public CustomerAddress findAddressByCustomerId(String customerId) {
		return addressRepository.findByCustomerId(customerId);
		
	}
	public Address findPrimaryAddress(String customerId) {
		for(Address address:addressRepository.findByCustomerId(customerId).getAddress())
			if(address.isPrimaryAddress())
				return address;
		return null;
	}
	

}
