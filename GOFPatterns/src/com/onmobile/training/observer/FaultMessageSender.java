package com.onmobile.training.observer;

public class FaultMessageSender implements FaultListener{

	@Override
	public void handlerFault(String msg) {
		// TODO Auto-generated method stub
		System.out.println("sending msg " + msg);
	}	
}
