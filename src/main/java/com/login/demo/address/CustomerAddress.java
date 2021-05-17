package com.login.demo.address;

import java.util.HashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import com.login.demo.address.model.Address;

public class CustomerAddress {
	@Id
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Indexed(name="CustomerID",unique=true)
	private String customerId;
	private HashSet<Address>address;
	private int maximumAddressId;
	
	public int getMaximumAddressId() {
		return maximumAddressId;
	}
	public void setMaximumAddressId(int maximumAddressId) {
		this.maximumAddressId = maximumAddressId;
	}
	public CustomerAddress(String customerId, HashSet<Address> address) {
		super();
		this.customerId = customerId;
		this.address = address;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public HashSet<Address> getAddress() {
		return address;
	}
	public void setAddress(HashSet<Address> address) {
		this.address = address;
	}
	

}
