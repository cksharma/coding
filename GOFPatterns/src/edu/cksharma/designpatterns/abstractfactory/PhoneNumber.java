package edu.cksharma.designpatterns.abstractfactory;

public abstract class PhoneNumber {
	private int phoneNumber;

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public abstract String getIsdCode();
	
	public String toString()
	{
		return getIsdCode() + " - " + phoneNumber;
	}
}
