package codecon.buffalo.palindrome;

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
		String s = in.nextLine();
		char[] ch = s.toCharArray();
		int ans = Integer.MIN_VALUE;
		
		for (int mid = 0; mid < ch.length; mid++) {
			String res1 = getMaxPallindromeForMid(mid, ch);
			String res2 = getMaxPallindromeForTwoMid(mid, mid + 1, ch);	
			
			int ans1 = getMyValue(res1);
			int ans2 = getMyValue(res2);
			ans = Math.max(Math.max(ans, ans1), ans2);
		}
		out.println(ans);
	}
	
	private int getMyValue(String res) {
		int ans = 0;
		if (res.length() <= 1) return ans;
		for (int i = 0; i < res.length(); i++) {
			ans += (res.charAt(i) - 'A' + 1);
		}
		return ans;
	}
	
	private String getMaxPallindromeForTwoMid(int mid1, int mid2, char[] ch) {
		int i = mid1, j = mid2;
		String ans = "";
		while (i >= 0 && j < ch.length) {
			if (ch[i] != ch[j]) {
				ans = new String(ch).substring(i + 1, j);
				break;
			}
			i--;
			j++;
		}
		if (i + 1 != j)
			return new String(ch).substring(i + 1, j);
		return ans;
	}
	
	private String getMaxPallindromeForMid(int mid, char[] ch) {
		String ans = "";
		int i = mid - 1, j = mid + 1;
		while (i >= 0 && j < ch.length) {
			if (ch[i] != ch[j]) {
				return new String(ch).substring(i + 1, j);								
			} 
			i--;
			j++;
		}
		if (i != j) {
			return new String(ch).substring(i + 1, j);
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