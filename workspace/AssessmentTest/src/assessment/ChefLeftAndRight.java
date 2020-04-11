package assessment;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

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
			boolean lastOdd = true;
			for (int k = 0; k < ch.length; k++) {
				if (ch[k] == 'l') {
					if (lastOdd == false) {
						ans = ans * 2 - 1;
					} else {
						ans = ans * 2;
					}
				} else {
					if (lastOdd == false) {
						ans = ans * 2 + 1;
					} else {
						ans = ans * 2 + 2;
					}
				}
				if (ans % 2 == 0) lastOdd = false;
				else lastOdd = true;
				if (ans >= MD) 
					lastOdd = !lastOdd;
				ans = ans % MD;
			}
			arr[i] = ans % MD;
		}
		for (int i = 0; i < T; i++) {
			out.println(arr[i]);
		}
	}
}


