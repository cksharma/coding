import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.StringTokenizer;

class SmallFactorial {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskJ solver = new TaskJ();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskJ {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int T = in.nextInt();
		while (T-- > 0) {
			
		}
	}
}

