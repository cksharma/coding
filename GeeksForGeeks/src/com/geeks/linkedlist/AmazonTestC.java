package com.geeks.linkedlist;

import java.util.ArrayList;
import java.util.List;

interface Stream {

	public char getNext();

	public boolean hasNext();

}

class B implements Stream {

	String str = "aBBa";
	int index = 0;
	@Override
	public char getNext() {
		return str.charAt(index++);
	}

	@Override
	public boolean hasNext() {
		return index < str.length();
	}
	
}

class AmazonTestC {
	public static void main(String[] args) {
		Stream ss = new B();
		char ck = firstChar(ss);
		System.out.println(ck);
	}
	static int[] arr = new int[(1 << 8) + 1];
	static List <Character> list = new ArrayList<Character>();
	public static char firstChar (Stream input) {
		char ch = input.getNext();
		arr[ch]++;
		list.add(ch);
		return ch; 	
	}
	static char getUniqueCharacter() {
		char ans = '#';
		for (char item : list) {
			if (arr[item] == 1) {
				ans = item;
				break;
			}
		}
		return ans;			 
	}
}
