package com.onmobile.training.observer;

import java.util.ArrayList;
import java.util.List;

public class FaultMessageGenerator {
	private List <FaultListener> listeners = new ArrayList <FaultListener> ();
	
	public void addFaultListener(FaultListener listener)
	{
		listeners.add(listener);
	}
	
	public void removeFaultListener(FaultListener listener)
	{
		listeners.remove(listener);
	}
	public void errorOccured(String message) 
	{
		for(FaultListener listener : listeners) {
			listener.handlerFault(message);
		}
	}
}
