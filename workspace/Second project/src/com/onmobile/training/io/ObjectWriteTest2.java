package com.onmobile.training.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class X implements Serializable
{
	private int i;
	X()
	{
		i = 10;
		System.out.println("Constructor of X");
	}
	X(int p)
	{
		i = p;
	}
	void print()
	{
		System.out.println("i = " + i);
	}
}

class Y extends X implements Serializable
{
	private int j;
	Y(int i, int j)
	{
		super(i);
		this.j = i;
		System.out.println("Y with two args");
	}
	void print()
	{
		super.print();
		System.out.println("j = " + j);
	}
}

public class ObjectWriteTest2 
{
	public static void main(String[] args) 
	{
		Y y1 = new Y(1, 2);
		try {
			FileOutputStream fout = new FileOutputStream("x.dat");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(y1);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			FileInputStream fin = new FileInputStream("x.dat");
			ObjectInputStream in = new ObjectInputStream(fin);
			Y y2 = (Y)in.readObject(); // if X implements serilizable then everything flows normally..
			y2.print();
			in.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		catch(ClassNotFoundException e2)
		{
			e2.printStackTrace();
		}
	}
}
