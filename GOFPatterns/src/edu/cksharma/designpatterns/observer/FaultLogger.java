package edu.cksharma.designpatterns.observer;

public class FaultLogger implements FaultListener{

	@Override
	public void handlerFault(String msg) {
		// TODO Auto-generated method stub
		System.out.println("Writing to the logfile " + msg);
	}	
}
