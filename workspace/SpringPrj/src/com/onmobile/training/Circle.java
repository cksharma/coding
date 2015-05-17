package com.onmobile.training;

public class Circle implements Shape {
	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}
}

// by deafult we have to put no arg cont if we have anu argumented const....  
//we can do this also by making the changes shown in applocationContext.xml
