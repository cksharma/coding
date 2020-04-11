// two X.class and X$Y.class are created
//here outer and inner class  both are non-static ..
//any member of outer class are accessible in the inner class.

class X
{
	int i = 10;
	static class Y
	{
		int i = 20;
		void print()
		{
			int i = 30;
			System.out.println("Method of non static class");
			System.out.println(i);  
			System.out.println(this.i);  // this is the object of the current class.
			//System.out.println(X.this.i); // X.this is the current object of the outer class.
		}
		static void helloGreetings() {
			System.out.println("Greetings from me");
		}
	}
	void print()
	{
		System.out.println("Method of outer class");
	}
}

public class InnerTest1
{
	public static void main(String[] args)
	{
		
	}
}