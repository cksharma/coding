package edu.cksharma.designpatterns.adaptor;

public class TravelUtilityAdapter implements FourWheeler{ 

	private ThreeWheeler tWheeler; // let it have a composotion with 3 wheeler and is a relationship with 4 wheeler
			
	public TravelUtilityAdapter(ThreeWheeler tWheeler) {
		super();
		this.tWheeler = tWheeler;
	}
	
	@Override
	public void travel() {
		// TODO Auto-generated method stub
		tWheeler.travel();
	}

}
