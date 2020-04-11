import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class First {
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

class TaskA {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		long a = in.nextLong();
		long b = in.nextLong();
		long ans = 0;
		while (b > 0) {
			ans += (a / b);
			long a_new = b;
			b = a % b;
			a = a_new;
		}
		System.out.println(ans);
	}
}
class InputReader {
	private BufferedReader reader;
	private StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream));
		tokenizer = null;
	}

	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}
	public long nextLong() {
		return Long.parseLong(next());
	}

	public String nextLine() {
		String inputLine = "";
		try {
			inputLine = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputLine;
	}
}
