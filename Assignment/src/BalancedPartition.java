import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BalancedPartition {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskBalancedPartition solver = new TaskBalancedPartition();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskBalancedPartition {
	
	int[] arr = new int[] {1, 2, 3, 4, 5};
	int diff = 1 << 25;
	int totalSum = 0;
	int oneHalfSum = 0;
	int[] dp;
	int[] visited;
	boolean terminateRecursion;
	
	private void recurseAndDP(int sum) {
		if (sum >= totalSum) return;
		if (dp[sum] != 0) return;
		dp[sum] = 1;
		int k = totalSum - sum;
		if (Math.abs(sum - k) < diff) {
			diff = Math.abs(sum - k);
			oneHalfSum = sum;
		}
		for (int i = 0; i < arr.length; i++) {
			recurseAndDP(sum + arr[i]);
		}
	}
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		for (int i = 0; i < arr.length; i++) {
			totalSum += arr[i];
		}
		dp = new int[totalSum + 1];
		recurseAndDP(0);
		System.out.println("One half sum = " + oneHalfSum);
		System.out.println("Next half sum = " + (totalSum - oneHalfSum));	
		if (diff == 1 << 25) {
			System.out.println("Not possible");
			System.exit(0);
		}
		visited = new int[arr.length];
		backTrackToFindPossibleSets(0, 0, totalSum);
	}
	
	private void backTrackToFindPossibleSets(int index, int currentSum, int remainSum) {
		visited[index] = 1;
		
		if (terminateRecursion) return;
		
		if (currentSum + arr[index] == oneHalfSum) {
			List <Integer> first = new ArrayList <Integer> ();
			List <Integer> second = new ArrayList <Integer> ();
			
			for (int i = 0; i <= index; i++) {
				if (visited[i] == 1) first.add(arr[i]);
				else second.add(arr[i]);
			}
			for (int i = index + 1; i < arr.length; i++) {
				second.add(arr[i]);
			}
			System.out.println("First partition " + first);
			System.out.println("Second partition " + second);
			terminateRecursion = true;
			return;
		}
		
		if (index + 1 < arr.length && currentSum + arr[index] + arr[index + 1] <= oneHalfSum) {
			backTrackToFindPossibleSets(index + 1, currentSum + arr[index], remainSum - arr[index]);
		}
		if (index + 1 < arr.length && currentSum + arr[index] + arr[index + 1] > oneHalfSum && currentSum - arr[index] + remainSum >= oneHalfSum) {
			visited[index] = 0;
			backTrackToFindPossibleSets(index + 1, currentSum, remainSum - arr[index]);
		}
	}
}