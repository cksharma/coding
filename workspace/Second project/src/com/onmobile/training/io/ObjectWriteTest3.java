package com.onmobile.training.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A 
{
	private int i;
	A(int p)
	{
		i = p;
	}
	void print()
	{
		System.out.println("i = " + i);
	}
}

class B implements Serializable
{
	private transient A a; // if we remove transient from here, then A should also implement serializable , else we get error.
						   
	private int j;
	B(A a, int j)
	{
		this.a = a;
		this.j = j;
	}
	void print()
	{
		if(a != null) a.print();
		System.out.println("j = " + j);
	}
}

public class ObjectWriteTest3 
{
	public static void main(String[] args) 
	{
		A a1 = new A(4);
		B b1 = new B(a1, 10);
		try {
			FileOutputStream fout = new FileOutputStream("a.dat");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(b1);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileInputStream fin = new FileInputStream("a.dat");
			ObjectInputStream oin = new ObjectInputStream(fin);
			B b = (B)oin.readObject();
			b.print();
			oin.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
