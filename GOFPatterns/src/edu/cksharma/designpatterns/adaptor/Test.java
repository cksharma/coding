package edu.cksharma.designpatterns.adaptor;

public class Test {
	public static void main(String[] args) {
		
		ThreeWheeler t = new Auto();
		
		//FourWheeler f = new Car();
		
		FourWheeler f = new TravelUtilityAdapter(t);
		TravelUtility.travelToOffice(f);
		
		//TravelUtility.travelToOffice(f); //lets assume that TravelUtility is developed by somneone else.
		// i have to pass Object of type car to TravelUtility.
		//lets say my car broke, i want to go to office by Auto. TravelUtility is not under my control.
		// I have to go to office with this TravelUtility only. If I pass the object of the ThreeWheeler to
		//the travelUtility it wont work. In between I need someone else who will be compatilble to 
		//3 wheeler , m just passing 4 wheeler type variable. How is it possible?
		
		// now adaptor having is a reln with one and has a rel with another. 
		// is a rel with the one which the TravelUtilty takes ar Argument.
	}
}
