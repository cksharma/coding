package com.onmobile.training.decorator;

public class Test {
	public static void main(String[] args) {
		OrdinaryCar ordCar = new OrdinaryCar();
		DeluxeCar dlxCar = new DeluxeCar(ordCar);
		dlxCar.describe();
		
		System.out.println();
		System.out.println("========================");
		System.out.println();
		
		OrdinaryCar ordCar1 = new OrdinaryCar();
		GPSCar gpsCar1 = new GPSCar(ordCar1);
		gpsCar1.describe();
		
		System.out.println();
		System.out.println("========================");
		System.out.println();
		
		OrdinaryCar ordCar2 = new OrdinaryCar();
		DeluxeCar dlxCar2 = new DeluxeCar(ordCar2);
		GPSCar gpsCar2 = new GPSCar(dlxCar2);
		gpsCar2.describe();
	}
}
