package testPackage;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class DiamondOperator {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskDiamondOperator solver = new TaskDiamondOperator();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskDiamondOperator {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		
	}
}
