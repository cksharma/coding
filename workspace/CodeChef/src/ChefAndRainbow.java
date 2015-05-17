import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;

class ChefAndRainbow {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskRainbow solver = new TaskRainbow();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskRainbow {

	//private final int MD = 1000000007;

	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int N = in.nextInt();
		if (N < 13) {
			out.println("0");
			return;
		}
		if (N % 2 == 0)
			N--;
		N = N - 7 - (N - 13) / 2;

		BigInteger b = new BigInteger("1");
		for (int i = N - 5; i <= N; i++) {
			b = b.multiply(new BigInteger(i + ""));			
		}
		b = b.divide(new BigInteger("720"));
		b = b.mod(new BigInteger("1000000007"));
		out.println(b.toString());
	}
}

/*class InputReader {
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

	public String nextLine() {
		String inputLine = "";
		try {
			inputLine = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputLine;
	}
}*/