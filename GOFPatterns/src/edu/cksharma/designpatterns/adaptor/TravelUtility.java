package edu.cksharma.designpatterns.adaptor;

public class TravelUtility {
	public static void travelToOffice(FourWheeler f)
	{
		f.travel();
		System.out.println("Reached Office");
	}
}
