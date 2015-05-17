import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ChefAndRedBlackTree {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		ChefAndRedBlackTreeB solver = new ChefAndRedBlackTreeB();
		solver.solve(1, in, out);
		out.close();
	}
}

class ChefAndRedBlackTreeB {
	
	private int countBlack(boolean firstBlack, int start, int end) {
		long blackLevel = firstBlack ? 1 : 2;
		int ans = 0;
		while (true) {
			long low = 1 << (blackLevel - 1);	
			long high = (1 << blackLevel) - 1;
			blackLevel++;
			if (low > end) break;
			
			if (start > high) continue;
			
			ans += Math.min(end, high) - Math.max(start, low) + 1;
			
		}
		return ans;
	}
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		boolean firstBlack = true;
		int Q = in.nextInt();
		List <Integer> list = new ArrayList <>();
		while (Q-- > 0) {
			String[] arr = in.nextLine().split(" ");
			switch(arr[0]) {
				case "Qi":
					firstBlack = !firstBlack;
					break;
				case "Qb":
				case "Qr":
					int start = Integer.parseInt(arr[1]);
					int end = Integer.parseInt(arr[2]);
					int blackCount = countBlack(firstBlack, start, end);
					int cnt = arr[0].equals("Qb") ? blackCount : end - start + 1 - blackCount;
					list.add(cnt);
					break;	
			}
		}
		for (int i = 0; i < list.size(); i++)
			out.println(list.get(i));
	}
}