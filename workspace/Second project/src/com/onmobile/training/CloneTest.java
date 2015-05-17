package com.onmobile.training;

class S implements Cloneable // the class should support cloning by introducing
							 // the Cloneable interface.
{
	private int i;

	S(int i)
	{
		this.i = i;
	}

	void print()
	{
		System.out.println(i);
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof S)
		{
			S s1 = (S) obj;
			return i == s1.i;
		}
		return false;
	}
}

public class CloneTest
{
	public static void main(String[] args)
	{
		S s1 = new S(4);
		S s2 = null;
		try
		{
			s2 = (S) s1.clone(); // cloning does bit by bit copying .....
								 // everything is cloned ..
		} 
		catch (CloneNotSupportedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s1.print();
		s2.print();
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
	}
}
