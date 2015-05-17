//import java.util.LinkedList;
//import java.util.List;
//
//interface A
//{
//	void test1();
//}
//
//interface B
//{
//	void test2();
//}
//
//class C
//{
//	void test3()
//	{
//		System.out.println("method of C");
//	}
//}
//
//class D extends C implements A, B
//{
//	public void test1() // this public keyword is a must coz all interface methods are by default public and abstract.
//	{
//		System.out.println("Method of A");
//	}
//	public void test2()
//	{
//		System.out.println("Method of B");
//	}
//}
//
//class InterfaceTest
//{
//	public static void main(String[] args)
//	{
//		D d1 = new D();
//		A a1 = d1;
//		a1.test1();
//		B b1 = d1;
//		b1.test2();
//		d1.test3();
//		System.out.println(d1 instanceof C);
//		System.out.println(d1 instanceof A);
//		System.out.println(d1 instanceof B);
//		System.out.println(a1 instanceof D);
//		System.out.println(b1 instanceof D);
//		
//		List <String> list = new LinkedList <String> ();
//		boolean b = list instanceof LinkedList;
//		System.out.println(b);
//	}
//}