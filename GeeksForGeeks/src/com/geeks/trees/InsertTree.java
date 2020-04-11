package com.geeks.trees;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class InsertTree {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskTreeInsert solver = new TaskTreeInsert();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskTreeInsert {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		Tree tree = Tree.treeGiven();		
		Tree node = tree;
		System.out.println("Enter the elements");
		int x = in.nextInt();
		node.insertTree(x);
		tree.printTree();
	}
}