package edu.cksharma.designpatterns.observer;

public class FaultEmailer implements FaultListener{

	@Override
	public void handlerFault(String msg) {
		// TODO Auto-generated method stub
		System.out.println("Emailing the error " +msg);
	}	
}
