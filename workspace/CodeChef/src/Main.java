import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		InputReader in = new InputReader(inputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in);
	}
}

class TaskB {
	public void solve(int testNumber, InputReader in) {
		long t, g, m = 0, s = 0, n = 0;
		List<Integer> pl = new ArrayList<Integer>();
		for (int i = 0; i < 32000; i++) {
			pl.add(0);
		}	
		pl.set(0, 1);
		pl.set(1, 1);

		List<Integer> pf = new ArrayList<Integer>();

		for (int i = 2; i < 32000; i++) {
			if (pl.get(i) == 0) {
				pf.add(i);
				for (int j = i + i; j < 32000; j += i) {
					pl.set(j, 1);
				}
			}
		}

		List<List<Long>> v1 = new ArrayList<List<Long>>();

		t = in.nextInt();
		for (g = 0; g < t; g++) {
			List<Long> v = new ArrayList<Long>();
			m = in.nextInt();
			n = in.nextInt();
			if (m <= 1) {
				while (m != 2)
					m++;
			}
			if (n < 32000) {
				for (int i = 0; pf.get(i) <= n; i++) {
					if (pf.get(i) >= m)
						v.add((long) pf.get(i));
				}
				v1.add(v);
			} else if (n >= 32000) {
				long l = (int) (Math.sqrt(n));
				List<Integer> test1 = new ArrayList<Integer>();
				for (int i = 0; i < n - m + 1; i++) test1.add(0);

				for (int i = 0; pf.get(i) <= l; i++) {
					if (m % pf.get(i) != 0)
						s = m + pf.get(i) - (m % pf.get(i));
					else if (m % pf.get(i) == 0)
						s = m;
					while (s <= n) {
						if (test1.get((int) (s - m)) == 0 && pf.get(i) != s)
							test1.set((int) (s - m), 1);
						s += pf.get(i);
					}

				}
				for (int i = 0; i < (n - m + 1); i++) {
					if (test1.get(i) == 0)
						v.add(i + m);
				}
				v1.add(v);
			}
		}
		
		for (int i = 0; i < v1.size(); i++) {
			for (int j = 0; j < v1.get(i).size(); j++)
				System.out.println(v1.get(i).get(j));
			System.out.println();
		}
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