package codecon.buffalo.ascii;

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
		String first = in.next();
		String secon = in.next();
		String ans1 = "";
		String ans2 = "";
		int value = 0;
		
		for (int i = 0; i < first.length(); i++) {
			for (int j = i; j < secon.length(); j++) {
				String str1 = first.substring(i, j + 1);
				String str2 = secon.substring(i, j + 1);
				boolean way1 = calculateWayOne(str1, str2);
				boolean way2 = calculateWayTwo(str1, str2);
				boolean way3 = calculateWayThree(str1, str2);
				if (way1 && way2 && way3) {
					if (str1.length() > ans1.length()) {
						ans1 = str1;
						ans2 = str2;
						value = getValue(str1, str2);
					}
				}
 			}
		}

		out.println(ans1);
		out.println(ans2);
		out.println(value);
	}
	
	private int getValue(String str1, String str2) {
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < str2.length(); i++) {
			ans = Math.max(ans, ch2[i] - ch1[i]);
		}
		return ans;
	}
	
	private boolean calculateWayOne(String str1, String str2) {
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		
		for (int i = 0; i < str2.length(); i++) {
			if (ch1[i] - ch1[0] != ch2[i] - ch2[0]) return false;
		}
		return true;
	}
	private boolean calculateWayTwo(String str1, String str2) {
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		for (int j = 0; j < str1.length(); j++) {
			for (int i = j; i < str2.length(); i++) {
				if (ch1[i] - ch1[j] != ch2[i] - ch2[j]) return false;
			}
		}	
		return true;
	}
	private boolean calculateWayThree(String str1, String str2) {
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		for (int j = 0; j < str1.length(); j++) {
			for (int i = j; i < str2.length(); i++) {
				if (ch1[j] == ch1[i] && ch2[i] != ch2[j]) return false;
				if (ch1[j] != ch1[i] && ch2[i] == ch2[j]) return false;
			}
		}	
		return true;
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