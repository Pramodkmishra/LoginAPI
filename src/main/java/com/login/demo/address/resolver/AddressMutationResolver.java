package com.login.demo.address.resolver;

import java.util.HashSet;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.login.demo.address.CustomerAddress;
import com.login.demo.address.model.Address;
import com.login.demo.address.model.input.AddressInput;
import com.login.demo.address.repository.AddressRepository;
@Component
public class AddressMutationResolver implements GraphQLMutationResolver{
	@Autowired
	AddressRepository addressRepository;
	CustomerAddress customerAddress;
	public CustomerAddress addAddress(String customerId,AddressInput addressInput) {
		HashSet<Address> set=new HashSet<Address>();
		Address address=new Address();
		try {
			BeanUtils.copyProperties(address,addressInput);
		} catch (Exception e) {
			e.printStackTrace();
		}
		customerAddress=addressRepository.findByCustomerId(customerId);
		if(customerAddress==null) {
			address.setId(1);
			address.setPrimaryAddress(true);
			set.add(address);
			customerAddress=new CustomerAddress(customerId,set);
			customerAddress.setMaximumAddressId(1);
			addressRepository.save(customerAddress);
			
		}
		else {
			address.setId(customerAddress.getMaximumAddressId()+1);
			if(address.isPrimaryAddress())
				for(Address add:customerAddress.getAddress())
					add.setPrimaryAddress(false);
			set.addAll(customerAddress.getAddress());
			set.add(address);
			customerAddress.setAddress(set);
			customerAddress.setMaximumAddressId(customerAddress.getMaximumAddressId()+1);
			addressRepository.save(customerAddress);
			
		}
		System.out.print(customerAddress);
		return customerAddress;
	}
	public CustomerAddress updateAddress(String customerId,int addressId,AddressInput addressInput) {
		HashSet<Address> set=new HashSet<Address>();
		Address address=new Address();
		try {
			BeanUtils.copyProperties(address,addressInput);
		} catch (Exception e) {
			e.printStackTrace();
		}
		customerAddress=addressRepository.findByCustomerId(customerId);
		address.setId(addressId);
		if(address.isPrimaryAddress())
			for(Address add:customerAddress.getAddress())
				add.setPrimaryAddress(false);
		for(Address add:customerAddress.getAddress())
			if(add.getId()!=addressId)
				set.add(add);
		set.add(address);
		customerAddress.setAddress(set);
		addressRepository.save(customerAddress);
	
		
		
		return customerAddress;
	}
	private void setDefaultPrimary(HashSet<Address> addSet) {
		for(Address add:addSet) {
			add.setPrimaryAddress(true);
			break;
		}
			
			
	}
	public CustomerAddress removeAddress(String customerId,int addressId) {
		customerAddress=addressRepository.findByCustomerId(customerId);
		int count=0;
		boolean flag=false;
		HashSet<Address> set=new HashSet<Address>();
		for(Address address:customerAddress.getAddress()) {
			if(address.getId()==addressId && address.isPrimaryAddress())
				flag=true;
			if(address.getId()!=addressId)
				set.add(address);
			count++;
		}
		if(count==1) {
			addressRepository.deleteById(customerAddress.getId());
			return null;
		}
			
		else {
			if(flag)
				setDefaultPrimary(set);
			customerAddress.setAddress(set);
			addressRepository.save(customerAddress);
			return customerAddress;
		}
		
	}

}
