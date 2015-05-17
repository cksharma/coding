package edu.cksharma.designpatterns.abstractfactory;

public interface AddressFactory {
	public Address createAddress();
	public PhoneNumber createPhoneNumber();
}
