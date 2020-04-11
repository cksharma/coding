package codecon.buffalo.gigaball;

//Problem        : Base Arithmetic
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_65
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

//Your submission should *ONLY* use the following class name
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
	
}

class TaskB {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int f = in.nextInt();
		int s = in.nextInt();
		int t = in.nextInt();
		int[] farr = new int[f];
		int[] sarr = new int[s];
		int[] tarr = new int[t];
		for (int i = 0; i < f; i++) farr[i] = in.nextInt();
		for (int i = 0; i < s; i++) sarr[i] = in.nextInt();
		for (int i = 0; i < t; i++) tarr[i] = in.nextInt();
			
		Map <Integer, Integer> map = new HashMap <>();
		for (int item1 : farr) {
			for (int item2 : sarr) {
				for (int item3 : tarr) {
					int sum = item1 + item2 + item3;
					if (map.containsKey(sum)) {
						map.put(sum, map.get(sum) + 1);
					} else {
						map.put(sum, 1);
					}
				}
			}
		}
		int ans = 0;
		int maxCount = 0;
		for (int key : map.keySet()) {
			int value = map.get(key);
			if (value > maxCount) {
				ans = key;
				maxCount = value;
			}
		}
		out.print(ans);
	}
}
class Pair<T, U> {
	private final T first;
	private final U second;
	private transient final int hash;

	public Pair(T f, U s) {
		this.first = f;
		this.second = s;
		hash = (first == null ? 0 : first.hashCode() * 31) + (second == null ? 0 : second.hashCode());
	}

	public T getFirst() {
		return first;
	}

	public U getSecond() {
		return second;
	}

	@Override
	public int hashCode() {
		return hash;
	}

	@Override
	public boolean equals(Object oth) {
		if (this == oth) {
			return true;
		}
		if (oth == null || !(getClass().isInstance(oth))) {
			return false;
		}
		Pair<T, U> other = getClass().cast(oth);
		return (first == null ? other.first == null : first.equals(other.first))
				&& (second == null ? other.second == null : second.equals(other.second));
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