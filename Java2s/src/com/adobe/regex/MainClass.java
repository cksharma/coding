package com.adobe.regex;

interface I {
	
}

public class MainClass {
	public static void main(String args[]) {
		String statement = "A B AA";
		String tokens[] = null;
		String splitPattern = "A|B|C|E|(G H I J)|(AA BB CC)";

		tokens = statement.split(splitPattern);
		System.out.println("REGEX PATTERN:\n" + splitPattern + "\n");
		System.out.println("STATEMENT:\n" + statement + "\n");
		System.out.println("TOKENS:");
		for (int i = 0; i < tokens.length; i++) {
			System.out.println(tokens[i]);
		}
	}
}