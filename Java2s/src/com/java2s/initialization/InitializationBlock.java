package com.java2s.initialization;

import java.util.ArrayList;
import java.util.List;

public class InitializationBlock {
	int i1;
	static int i2;
	
	{
		System.out.println(i1);
		i1 = 6;
		System.out.println(i1);
	}
	
	static {
		System.out.println(i2);
		i2 = 8;
		System.out.println(i2);
	}
	
	void f() {
		System.out.println("Chandra Kant");
	}
	
	{
		i1 = 10;
		System.out.println(i1);
	}
	public static void main(String[] args) {
		System.out.println("Main entered");
		//InitializationBlock iniBlock = new InitializationBlock();
		//iniBlock.f();
		System.out.println("Main exited");
		List <String> list = new ArrayList<>();
		Object kk = new Object();
				
	}
	InitializationBlock bb = new InitializationBlock();
}
