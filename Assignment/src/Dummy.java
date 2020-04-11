import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Dummy {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskCoin solver = new TaskCoin();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskCoin {
	
	int[] deno = {1, 2, 3, 4, 5};
	
	int desiredSum;
	
	public static int INF = 1 << 20;
	
	int minCoins = INF;
	
	public void recurse1(int sum, int steps) {
		if (sum == 0) {
			minCoins = Math.min(minCoins, steps);
			return;
		}
		for (int i = 0; i < deno.length; i++) {
			if (deno[i] <= sum) 
				recurse1(sum - deno[i], steps + 1);
			else return;
		}
	}
	
	public void recurse(int sum, int steps) {
		if (sum == 0) {
			minCoins = Math.min(minCoins, steps);
			return;
		}
		for (int i = 0; i < deno.length; i++) {
			for (int count = 1; count * deno[i] <= sum; count++) {
				recurse(sum - count * deno[i], steps + count);
			}
		}
	}
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		desiredSum = in.nextInt();
		//recurse(desiredSum, 0);
		recurse1(desiredSum, 0);
		System.out.println(minCoins);
	}
}
