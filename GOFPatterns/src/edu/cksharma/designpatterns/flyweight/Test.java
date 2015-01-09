package edu.cksharma.designpatterns.flyweight;

public class Test {
	public static void main(String[] args) {
		MathOperation op1 = MathOperationFlyWeightFactory.createObject('+');
		System.out.println(op1.performOperation(3, 4));
		
		MathOperation op2 = MathOperationFlyWeightFactory.createObject('*');
		System.out.println(op2.performOperation(3, 4));
		
		System.out.println(op1 == op2);
		
		MathOperation op3 = MathOperationFlyWeightFactory.createObject('+');
		System.out.println(op3.performOperation(10, 20));
		System.out.println(op1 == op3);		
	}
}
