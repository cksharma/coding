package codecon.buffalo.dirtystack;

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
	
	static class State {
		int value;
		boolean dirty;
		
		State(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value + "  " + dirty;
		}
		
	}
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		List <State> list = new ArrayList <>();
		for (int i = 0; i < n; i++) list.add(new State(in.nextInt()));
		
		//List <Integer> ans = new ArrayList <>();
		StringBuilder sb = new StringBuilder();
		
		outer: while (list.size() > 1) {
			//System.out.println(list);
			State curr = list.get(0);
			if (curr.value >= list.size()) {
				sb.append(curr.value + ",");
				list.remove(0);
				continue outer;
			}
			State targ = list.get(curr.value);
			
			if (targ.dirty) {
				sb.append(curr.value + ",");
				list.remove(0);
				//list.set(0, targ);
				continue outer;
			} 
			curr.dirty = true;
			Collections.swap(list, 0, curr.value);		
		}
		sb.append(list.get(0).value);		
		out.println(sb);
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