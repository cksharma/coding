package com.onmobile.training.enums;

public class EnumTest1 {

	public static final char GRADE_O = 'O';
	public static final char GRADE_A = 'A';
	public static final char GRADE_B = 'B';
	public static final char GRADE_C = 'C';
	
	public static void main(String[] args) 
	{
		printGrade('A'); // there is always chance of passing Z or Y values. To address this issue
		//we declare enum type. enum is used to define the own type by the user.
		// enum data type are accepted by switch statements.
	}
	
	public static void printGrade(char c)
	{
		switch(c)
		{
			case GRADE_O : 
				System.out.println("Excellent, keep it up");
				break;
			case GRADE_A:
				System.out.println("Good, try for O Grade");
				break;
			case GRADE_B:
				System.out.println("Improve your performance");
				break;
			case GRADE_C:
				System.out.println("Not statisfied with your performance");
				break;
			default :
				System.out.println("Not a valid grade");
		}
	}
}
