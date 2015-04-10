package codecon.florida.tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem {
	public static void main(String[] args) {
		TaskB solver = new TaskB();
		solver.solve();
	}
}

class TaskB {
	
	private int getIndex(int[] arr, boolean[] visited) {
		int index = -1;
		Map <Integer, Integer> mapLeft = new HashMap <Integer, Integer> ();
		Map <Integer, Integer> mapRigh = new HashMap <Integer, Integer> ();
		
		int prev = 0;
		for (int i = 1; i < arr.length; i++) {
			if (visited[i] == false) {
				mapLeft.put(i, arr[i] - arr[prev]);
			} else {
				prev = i;
			}
		}
		
		int next = arr.length - 1;
		for (int i = next - 1; i >= 0; i--) {
			if (visited[i] == false) {
				mapRigh.put(i, arr[next] - arr[i]);
			} else {
				next = i;
			}
		}
		
		int min = Integer.MIN_VALUE;
		for (int item : mapLeft.keySet()) {
			if (min < Math.min(mapLeft.get(item), mapRigh.get(item))) {
				index = item;
				min = Math.min(mapLeft.get(item), mapRigh.get(item));
			}
		}		
		return index;
	}
	
	public void solve() {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int S = in.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = in.nextInt();
		in.close();
		Arrays.sort(arr);
		int cnt = 2;
		boolean[] visited = new boolean[N];
		visited[0] = true;
		visited[N - 1] = true;
		
		while (cnt < S) {
			int index = getIndex(arr, visited);
			visited[index] = true;
			cnt++;			
		}		
		int ans = Integer.MAX_VALUE;
		int prev = 0;
		for (int i = 1; i < N; i++) {
			if (visited[prev] && visited[i]) {
				ans = Math.min(ans, arr[i] - arr[prev]);
				prev = i;
			}
			
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
