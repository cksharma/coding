package com.onmobile.training.enums;

import java.util.Scanner;

enum Grade1
{
	O("Excellent"), A("Good"), B("Average"), C("Poor");
	private String remarks;
	Grade1(String remarks) //by default this is private coz enum constructors are private by default.
	{
		this.remarks = remarks;
	}
	public String getRemarks()
	{
		return remarks;
	}
	public String toString()
	{
		return super.toString() + "\t" + remarks;
	}
}

public class EnumTest3 
{
	public static void main(String[] args) 
	{
		//printGrade(Grade1.A);
		System.out.println("Enter the garde ");
		Scanner sc = new Scanner(System.in);
		String grade = sc.nextLine();
		Grade1 g = Grade1.valueOf(grade); // we pass wrong value we get exception in this line itself, so method printGrade is not invoked.
		printGrade(g);
		System.out.println(g.getRemarks());
	}
	
	public static void printGrade(Grade1 c)
	{
		System.out.println("Grade is " + c);
	
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
