package com.onmobile.javapractises;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class MySpecialList {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

interface MyInterface<E> extends List<E> {
	List<E> removeOdd();

	List<E> removeEven();
}

class MyImplementation<E> extends LinkedList<E> implements MyInterface<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<E> removeOdd() {
		// TODO Auto-generated method stub
		List<E> list = new LinkedList<E>();
		return null;
	}

	@Override
	public List removeEven() {
		// TODO Auto-generated method stub
		List<E> list = new LinkedList<E>();
		return null;
	}

}

class TaskA {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		MyInterface<Integer> list = new MyImplementation<Integer>();
		for (int i = 0; i < 10; i++)
			list.add(0);
	}
}