package edu.cksharma.designpatterns.decorator;

public class OrdinaryCar implements FourWheeler {

	@Override
	public void describe() {
		// TODO Auto-generated method stub
		System.out.println("Add Engine");
		System.out.println("Add Wheels");
		System.out.println("Add Body");
	}	
}