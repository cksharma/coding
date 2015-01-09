package com.onmobile.training.decorator;

public class GPSCar implements FourWheeler {

	private FourWheeler fourWheeler;
	
	public GPSCar(FourWheeler fourWheeler) {
		super();
		this.fourWheeler = fourWheeler;
	}

	@Override
	public void describe() {
		// TODO Auto-generated method stub
		fourWheeler.describe();
		System.out.println("Adding GPS System");
	}	
}
