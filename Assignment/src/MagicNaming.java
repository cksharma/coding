import java.util.Arrays;

public class MagicNaming {

	int[][] DP;
	
	int maxReindeers(String magicName) {
		DP = new int[magicName.length() + 1][magicName.length() + 1];
		for (int i = 0; i < DP.length; i++)
			Arrays.fill(DP[i], Integer.MIN_VALUE);
		for (int j = 1; j <= magicName.length(); j++)
			DP[1][j] = 1;
		for (int i = 1; i <= magicName.length(); i++) {
			for (int j = i; j <= magicName.length(); j++) {
				if (i == 1)
					DP[i][j] = 1;
				for (int k = i - 1; k >= 1; k--) {
					if (((magicName.substring(k - 1, i - 1) + magicName.substring(i - 1, j)).compareTo((magicName
							.substring(i - 1, j) + magicName.substring(k - 1, i  - 1)))) <= 0)

						DP[i][j] = Math.max(DP[i][j], DP[k][i - 1] + 1);

				}

			}
		}
		int ans = 0;
		for (int i = 1; i < DP.length; i++)
			ans = Math.max(ans, DP[i][magicName.length()]);
		return ans;
	}

	public static void main(String[] args) {
		String magicName = "philosophersstone";
		int n = new MagicNaming().maxReindeers(magicName);
		System.out.println("n = " + n);
	}
}
