package com.onmobile.training;

public class InsufficientItemException extends RuntimeException{

	public InsufficientItemException() {
		super();
		
	}
	
	public InsufficientItemException(String message) {
		super(message);
	}
}
