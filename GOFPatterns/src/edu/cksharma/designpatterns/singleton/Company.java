package edu.cksharma.designpatterns.singleton;

import java.io.Serializable;

public class Company implements Serializable{ // if i imp. serializable then i am compromising singleton.evertime it is read from the file, a new object is made..
	
	//even if i implement this interface and wants to make it Sngleton, i will override readResolve() method.
	
	private static Company instance;
	
	private Company()
	{
		
	}
	public static Company getInstance()
	{
		synchronized (Company.class) {
		
			if(instance == null) instance = new Company(); // for object on demand u should take care of synchronization
			return instance;
		}	
	}
	
	public String getName()
	{
		return "On Mobile";
	}
	
	//the new object is also created by readObject method, but JVM takes the method from readRsolve(), not the
	//object that was read by readObject. THis object now is eligible for GC.
	// now using this readResolve same instance is returned. Spo it'sstill singleton despite i have imp. Serilizable interface.
	//make this method as private.
	private Object readResolve() 
	{
		System.out.println("Read resolve method");
		return instance;
	}
}