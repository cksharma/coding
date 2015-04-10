import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class PrimeRange {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskPrime solver = new TaskPrime();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskPrime {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int[] pl = new int[32000];
		int[] pf = new int[16000];
		int pfSize = 0;
		pl[0] = 1; pl[1] = 1;
		for (int i = 2; i < 32000; i++) {
			if (pl[i] == 0) {
				pf[pfSize++] = i;
				for (int j = i + i; j < 32000; j += i) pl[j] = 1;
			}
		}
		int T = in.nextInt();
		long[] v = new long[9600]; int vIndex = 0;
		long[][] v1 = new long[T][]; int v1Index = 0;
					
		while (T-- > 0) {
			int m = in.nextInt();
			int n = in.nextInt();
			int s = 0;
			while (m < 2) m++;
			if (n < 32000) {
				for (int i = 0; pf[i] <= n; i++) {
					if (pf[i] >= m) 
						v[vIndex++] = pf[i];
				}
				v1[v1Index++] = v;
				v = new long[9600];
				vIndex = 0;
			} else {
				long l = (int)Math.sqrt(n);
				int[] test = new int[n - m + 1];
				for (int i = 0; pf[i] <= l; i++) {
					if (m % pf[i] != 0) 
						s = m + pf[i] - (m % pf[i]);
					else if (m % pf[i] == 0) 
						s = m;
					while (s <= n) {
						if (test[s - m] == 0 && pf[i] != s) 
							test[s - m] = 1;
						s += pf[i];
					}
				}
				for (int i = 0; i < (n - m + 1); i++) {
					if (test[i] == 0) 
						v[vIndex++] = i + m;
				}
				v1[v1Index++] = v;
				v = new long[9600];	
				vIndex = 0;
			}
		}
		for (int i = 0; i < v1.length; i++) {
			for (int j = 0; j < v1[i].length; j++) {
				if (v1[i][j] == 0) break;
				out.println(v1[i][j]);
			}
			out.println();
		}
	}
}
