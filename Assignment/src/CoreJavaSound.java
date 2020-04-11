import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class CoreJavaSound {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskBT solver = new TaskBT();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskBT {
	int[] arr;
	int[] used;
	int desiredSum;
	
	private void backTrack(int index, int currentSum, int remainSum) {
		used[index] = 1;
		if (currentSum + arr[index] == desiredSum) {
			for (int i = 0; i < arr.length; i++) {
				if (used[i] > 0) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}
		
		if (index + 1 < arr.length && currentSum + arr[index] + arr[index + 1] <= desiredSum) {
			backTrack(index + 1, currentSum + arr[index], remainSum - arr[index]);
		}
		if (index + 1 < arr.length && currentSum + arr[index + 1] <= desiredSum && currentSum - arr[index] + remainSum >= desiredSum) {
			used[index] = 0;
			backTrack(index + 1, currentSum, remainSum - arr[index]);
		}
	}
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		arr = new int[n];
		used = new int[n];
		int totalSum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();		
			totalSum += arr[i];
		}		
		Arrays.sort(arr);
		desiredSum = in.nextInt();
		assert desiredSum > totalSum : "Not possible for this desiredsum";
		backTrack(0, 0, totalSum);
	}
}