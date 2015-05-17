package com.onmobile.training;

class PPP <T1, T2>
{
	T1 first;
	T2 second;
	public PPP(T1 first, T2 second) 
	{
		super();
		this.first = first;
		this.second = second;                                       
	}
	@Override
	public String toString() {
		return "PPP [first=" + first + ", second=" + second + "]";
	}
}

class QQQ 
{
	public <T> String concatenate(T xxx, T yyy) // we are making method as generic . it can accept any T type now..
	// nongeneric class is also having generic method.
	{
		return xxx.toString() + yyy.toString();
	}
	
	static <T> void print(T xx)
	{
		System.out.println(xx);
	}
}

public class GenericTest 
{
	public static void main(String[] args) 
	{
		PPP <Integer, Integer> p1 = new PPP <Integer, Integer> (23, 34);
		System.out.println(p1);
		QQQ q = new QQQ();
		System.out.println(q.concatenate("Hello", "World"));
		System.out.println(q.concatenate(p1, new PPP <Integer, String> (2, "Arjun")));
		System.out.println(q.concatenate(1, "Rajesh"));  // if we do like this by default it takes all the arguments as object type. 
		System.out.println(q.<String> concatenate("Hello", "Arjun")); // here we are specifying it to be string type from here itself.
		QQQ.print("hello");
		QQQ.<Integer> print(45);
	}
}
