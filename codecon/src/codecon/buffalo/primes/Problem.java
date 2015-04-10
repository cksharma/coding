package codecon.buffalo.primes;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
	
	private int ans;
	private int target;
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		this.target = n;
		List <Integer> primes = getPrimes(n);
		Collections.sort(primes);
		//System.out.println(primes);
		int[] S = new int[primes.size()];
		for (int i = 0; i < primes.size(); i++) {
			S[i] = primes.get(i);
		}
		int[] arr = new int[primes.size()];
		subsets_recurse(S, 0, arr, 0);
		out.println(ans);
	}
	
	private void subsets_recurse(int[] S, int index, int[] arr, int runningSum) {
		arr[index] = 1;
		if (runningSum + S[index] == target) {
			ans++;
		} else if (index + 1 < S.length && runningSum + S[index] < target) {
			subsets_recurse(S, index + 1, arr, runningSum + S[index]);
		}
		if (index + 1 < S.length && runningSum + S[index + 1] <= target) {
			arr[index] = 0;
			subsets_recurse(S, index + 1, arr, runningSum);
		}
	}
	private List <Integer> getPrimes(int n) {
		List <Integer> ans = new ArrayList <>();
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);
		primes[0] = false; primes[1] = false;
		for (int i = 2; i * i <= n; i++) {
			if (primes[i]) {
				for (int j = i * i; j <= n; j += i) {
					primes[j] = false;
				}
			}
		}
		for (int i = 2; i <= n; i++) {
			if (primes[i]) ans.add(i);
		}
		return ans;
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