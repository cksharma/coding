package easy;
public class ZigZagConversion {
	public String convert(String s, int nRows) {
		StringBuilder sb = new StringBuilder();
		char[] ch = s.toCharArray();
		nRows = Math.min(nRows, ch.length);
		int k = (nRows - 1) * 2;
		int fir = k;
		int sec = 0;

		if (fir == 0 && sec == 0) {
			sb.append(s);
		} else {
			for (int i = 0; i < nRows; i++) {
				int cnt = i;
				sec = k - fir;
				sb.append(ch[cnt]);
				while (cnt < ch.length) {
					cnt += fir;
					if (cnt < ch.length && fir != 0) {
						sb.append(ch[cnt]);
					}
					cnt += sec;
					if (cnt < ch.length && sec != 0) {
						sb.append(ch[cnt]);
					}
				}
				fir = fir - 2;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ZigZagConversion sol = new ZigZagConversion();
		System.out.println(sol.convert("PAYPALISHIRING", 3));
		System.out.println(sol.convert("ABC", 2));
		System.out.println(sol.convert("A", 1));
		System.out.println(sol.convert("A", 2));
		System.out.println(sol.convert("", 1));
	}
}
