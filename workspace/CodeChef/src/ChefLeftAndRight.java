import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class ChefLeftAndRight {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskChefLeftAndRight solver = new TaskChefLeftAndRight();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskChefLeftAndRight {
	
	private static final int MD = 1000000007;
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int T = in.nextInt();
		int ans = 1;
		int[] arr = new int[T];
		for (int i = 0; i < T; i++) {
			char[] ch = in.next().toCharArray();
			ans = 1;
			for (int k = 0; k < ch.length; k++) {
				if (ch[k] == 'l') {
					if (k % 2 == 1) {
						ans = ans * 2 - 1;
					} else {
						ans = ans * 2;
					}
				} else {
					if (k % 2 == 1) {
						ans = ans * 2 + 1;
					} else {
						ans = ans * 2 + 2;
					}
				}
				ans = ans % MD;
			}
			arr[i] = ans % MD;
		}
		for (int i = 0; i < T; i++) {
			out.println(arr[i]);
		}
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