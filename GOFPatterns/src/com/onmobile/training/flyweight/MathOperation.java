package com.onmobile.training.flyweight;

public class MathOperation {
	private char operator;

	public MathOperation(char operator) {
		super();
		this.operator = operator;
	}
	
	public int performOperation(int a, int b)
	{
		int result = 0;
		switch(operator)
		{
		case '+':
			result = a + b;
			break;
		case '-':
			result = a - b;
			break;
		case '*':
			result = a * b;
			break;
		case '/':
			result = a / b;
			break;
		}
		return result;
	}
	
}
