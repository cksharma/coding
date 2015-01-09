package com.onmobile.training.abstractfactory;

public class IndianAddressFactory implements AddressFactory{

	@Override
	public Address createAddress() {
		// TODO Auto-generated method stub
		return new IndianAddress();
	}
	
	@Override
	public PhoneNumber createPhoneNumber() {
		// TODO Auto-generated method stub
		return new IndianPhoneNumber();
	}	
}
