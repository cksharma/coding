package com.onmobile.training.aop;

public class Instrumentalist {

	public void play()
	{
		System.out.println("Playing instrument");
		System.out.println(5/0);		
	}
	
	public void play(String song)
	{
		System.out.println("Playing instrument " + song );
	}
}