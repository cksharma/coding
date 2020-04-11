package edu.cksharma.designpatterns.decorator;

public class DeluxeCar implements FourWheeler {

	private FourWheeler fourWheeler;
		
	public DeluxeCar(FourWheeler fourWheeler) {
		super();
		this.fourWheeler = fourWheeler;
	}

	@Override
	public void describe() {
		// TODO Auto-generated method stub
		fourWheeler.describe();
		System.out.println("Adding A/C");
		System.out.println("Adding Stereo System");
	}	
}
