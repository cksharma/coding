package easy;
public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		n = n - 1;
		while (n >= 0) {
			int mod = n % 26;
			sb.append((char)('A' + mod));
			n = n / 26 - 1;
		}
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		ExcelSheetColumnTitle sol = new ExcelSheetColumnTitle();
		System.out.println(sol.convertToTitle(53));
	}
}
