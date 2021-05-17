package com.login.demo.address.model.input;

public class AddressInput {
	private int id;
	private String addressLine1;
	private String addressLine2;
	private String landmark;
	private String pincode;
	private String city;
	private String state;
	private boolean primaryAddress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean isPrimaryAddress() {
		return primaryAddress;
	}
	public void setPrimaryAddress(boolean primaryAddress) {
		this.primaryAddress = primaryAddress;
	}
	public AddressInput(String addressLine1, String addressLine2, String landmark, String pincode, String city,
			String state, boolean primaryAddress) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.landmark = landmark;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
		this.primaryAddress = primaryAddress;
	}
	public AddressInput() {
		
	}
}
