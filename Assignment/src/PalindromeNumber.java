import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class PalindromeNumber {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int K = in.nextInt();
		while (K-- > 0) {
			String str = in.nextLine();
			int len = str.length();
			if (len < 2) {
				out.println(str);
				continue;
			}else if (allNineDigits(str)) {
				out.println(calculateForAllNine(str));
				continue;
			} else {
				char[] s = str.toCharArray();
				char[] s1 = str.toCharArray();
				int l = s1.length;
				int i, n;
				if (l % 2 == 1) {
					for (i = 0; i <= l / 2; i++) {
						s[l - 1 - i] = s[i];
					}
					if (compareArray(s, s1) <= 0) {
						if (s[l / 2] < '9') {
							s[l / 2] = (char) (s[l / 2] + 1);
						} else {
							n = l / 2;
							while (s[n] == '9') {
								s[n] = '0';
								n--;
							}
							s[n] = (char) (s[n] + 1);
						}
						for (i = 0; i <= l / 2; i++) {
							s[l - 1 - i] = s[i];
						}
					}
				} else {
					for (i = 0; i < l / 2; i++) {
						s[l - 1 - i] = s[i];
					}
					if (compareArray(s, s1) <= 0) {
						if (s[(l / 2) - 1] < '9') {
							s[(l / 2) - 1] = (char) (s[(l / 2) - 1] + 1);
						} else {
							n = (l / 2) - 1;
							while (s[n] == '9') {
								s[n] = '0';
								n--;
							}
							s[n] = (char) (s[n] + 1);
						}
						for (i = 0; i < l / 2; i++) {
							s[l - 1 - i] = s[i];
						}
					}
				}
				out.println(new String(s));
			}			
		}
	}

	public int compareArray(char[] s, char[] s1) {
		for (int i = 0; i < s.length; i++) {
			if (s[i] < s1[i])
				return -1;
			if (s[i] > s1[i])
				return 1;
		}
		return 0;
	}

	public String calculateForAllNine(String str) {
		String ans = "1";
		for (int i = 0; i < str.length() - 1; i++)
			ans += "0";
		ans += "1";
		return ans;
	}

	public boolean allNineDigits(String str) {
		boolean ans = true;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '9')
				ans = false;
		}
		return ans;
	}
}