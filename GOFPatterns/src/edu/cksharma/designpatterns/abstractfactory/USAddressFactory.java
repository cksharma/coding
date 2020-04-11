package edu.cksharma.designpatterns.abstractfactory;

public class USAddressFactory implements AddressFactory{

	@Override
	public Address createAddress() {
		// TODO Auto-generated method stub
		return new USAddress();
	}

	@Override
	public PhoneNumber createPhoneNumber() {
		// TODO Auto-generated method stub
		return new USPhoneNumber();
	}
	
}
