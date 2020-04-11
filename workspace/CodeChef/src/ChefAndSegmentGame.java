import java.util.*;
import java.io.*;

class ChefAndSegmentGame {
	static int getKBits(long K) {
		int cnt = 0;
		while (K > 0) {
			cnt++;
			K /= 2;
		}
		return cnt;
	}

	public static void main(String[] args) {
		
		PrintWriter out = new PrintWriter(System.out);
		Scanner si = new Scanner(System.in);
		int T = si.nextInt();
		
		while (T-- > 0) {
			double X = si.nextDouble();
			long K = si.nextLong();
		
			int k_bits = getKBits(K);
			long lowest = 1;
			for (int i = 0; i < k_bits - 1; i++) lowest *= 2;
			
			long highest = lowest * 2;
			
			double ans1 = X / highest;
			double ans2 = (K - lowest) * X / lowest;
			double ans = ans1 + ans2;
			out.println(ans);
		}
		out.close();
	}
}
