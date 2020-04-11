package com.onmobile.training.enums;

enum Grade{O, A, B, C};  // can be declared within the package also like this.

public class EnumTest2 
{
	enum Grade{O, A, B, C}; // when enum  are declared inside the class they are considered as the static inner classes.
	//they cannot be within the methods.
	
	public static void main(String[] args)
	{
		printGrade(Grade.A); // now user cannot pass any other values. In case he tries to do so, compilation error....
		//enum can exist simply directly inside the package or within the class.
	}
	
	public static void printGrade(Grade c)
	{
		switch(c)
		{
			case O : 
				System.out.println("Excellent, keep it up");
				break;
			case A:
				System.out.println("Good, try for O Grade");
				break;
			case B:
				System.out.println("Improve your performance");
				break;
			case C:
				System.out.println("Not statisfied with your performance");
				break;
			default :
				System.out.println("Not a valid grade");
		}
	}
}
