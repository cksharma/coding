import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public final class Main {

	static int MD = (int) 1e9 + 7;

	static int[][] dp = new int[101][101];

	static int numOfPlaylist(int N, int K, int L) {
		for (int i = 0; i <= L; i++)
			dp[i][0] = 1;
		for (int i = 1; i <= L; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % MD;
			}
		}
		long ans = 0;
		for (int r = 1; r <= L; r++) {
			long result = 1;
			for (int i = 1; i <= N; i++) {
				if (i - 1 <= K)
					result = (long) result * (r - (i - 1)) % MD;
				else
					result = (long) result * (r - K) % MD;
			}
			result = (long) result * dp[L][r] % MD;
			if (r % 2 == L % 2)
				ans = (ans + result) % MD;
			else
				ans = (ans + MD - result) % MD;
		}
		return (int) ans;
	}

	public static void main(String[] args) {
		Main.InputReader in = new Main.InputReader(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int L = in.nextInt();
		
		int ans = numOfPlaylist(N, K, L);
		System.out.println(ans);
	}
	
	static class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		InputReader(InputStream stream) {
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
}
