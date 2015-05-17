package testPackage;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Test {
	public static void main(String[] args) {
		String hello = "Hello", lo = "lo";
		System.out.print((hello == "Hello") + " ");
		System.out.print((Other.hello == hello) + " ");
		System.out.print((other.Other.hello == hello) + " ");
		System.out.print((hello == ("Hel" + "lo")) + " ");
		System.out.print((hello == ("Hel" + lo)) + " ");
		System.out.println(hello == ("Hel" + lo).intern());
		int k = 10_000;
		Other.autoClosable();
	}
}

class Other {
	static String hello = "Hello";
	void switchTest() {
		String str = "abcd";
		switch(str) {
			case "ABCD":
				break;
		}
	}
	
	static void autoClosable() {
		try (FileOutputStream fout = new FileOutputStream("a.txt", true);
				DataOutputStream dout = new DataOutputStream(fout)) {
			dout.writeUTF("hahahaha");
			System.out.println("\nI am here");
		} catch (Exception e) {
			System.out.println("haha");
		}
	}
}