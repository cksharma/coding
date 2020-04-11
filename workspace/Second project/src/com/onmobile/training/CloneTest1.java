package com.onmobile.training;

// this is doing shallow copying. It's like clone of person but sharing the legs.

class AA implements Cloneable
{
	BB b;
	public AA(BB b)
	{
		this.b =  b;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}

class BB{
	int i;
	public BB(int i)
	{
		this.i = i;
	}
}

public class CloneTest1 {
	public static void main(String[] args) {
		BB b1 = new BB(10);
		AA a1 = new AA(b1);
		AA a2 = null;
		try {
			a2 = (AA)a1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(a1 == a2); 
		System.out.println(a1.b == a2.b); // since we haven't implemented Cloneable on B .. this is always true. this is shallow cloning.
		// in deep cloning this should also be false.
	}
}
