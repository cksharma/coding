package edu.cksharma.designpatterns.abstractfactory;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddressFactory indFactory = new IndianAddressFactory();
		
		Address indAddress = indFactory.createAddress();
		indAddress.setLocation("121 -J P Nagar IV Block");
		indAddress.setCity("Bangalore");
		System.out.println(indAddress);
		PhoneNumber indPhone = indFactory.createPhoneNumber();
		indPhone.setPhoneNumber(991234568);
		System.out.println(indPhone);
		
		AddressFactory usFactory = new USAddressFactory();
		Address usAddress = usFactory.createAddress();
		usAddress.setLocation("1001 MidRand");
		usAddress.setCity("Los Angeles");
		System.out.println(usAddress);
		PhoneNumber usPhone = indFactory.createPhoneNumber();
		usPhone.setPhoneNumber(23654);
		System.out.println(usPhone);
		
		
	}

}
