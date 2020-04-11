package com.onmobile.training;

// this is doing deep copying. It's like clone of person and also having each parts different

class AAA implements Cloneable
{
	BBB b;
	public AAA(BBB b)
	{
		this.b =  b;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		AAA a1 = (AAA) super.clone(); // cloned object of AAA is now stored in a1
		a1.b = (BBB)b.clone(); // cloned b of BBB is now with a1 .. and a1 is returned.
		return a1;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof AAA)
		{
			AAA a = (AAA)obj;
			return b.equals(a.b);
		}
		return false;
	}
}

class BBB implements Cloneable
{
	int i;
	public BBB(int i)
	{
		this.i = i;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BBB)
		{
			BBB b1 = (BBB) obj;	
			return i == b1.i;
		}
		return false;
	}
}

public class CloneTest2 {
	public static void main(String[] args) {
		BBB b1 = new BBB(10);
		AAA a1 = new AAA(b1);
		AAA a2 = null;
		try {
			a2 = (AAA)a1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println(a1 == a2); 
		System.out.println(a1.b == a2.b); 
		System.out.println(a1.equals(a2));
	}
}
