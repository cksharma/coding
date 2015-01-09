package com.geeks.bits;

import java.util.Scanner;

public class Decimal {

	static boolean validateString(String str) {
		int dotCount = 0;
		int r = 0;
		if (str.charAt(0) == '-')
			r = 1;
		for (int i = r; i < str.length(); i++) {
			if (str.charAt(i) == '.') {
				dotCount++;
				continue;
			}	
			if (str.charAt(i) < '0' || str.charAt(i) > '9')
				return false;
		}
		return dotCount < 2;
	}

	static String getBeforeDecimal(String str) {
		int k = Integer.parseInt(str);
		String ans = "";
		while (k > 0) {
			int a = k % 2;
			ans += a;
			k /= 2;
		}
		return new StringBuilder(ans).reverse().toString();
	}

	static String calculateAfterDecimal(String str) {
		while (str.length() < 4) str += "0";
		str = str.substring(0, 4);
		int ok = Integer.parseInt(str);
		int[] dd = {5000, 2500, 1250, 625};
		int[] index = new int[4];
		int diff = Integer.MAX_VALUE;
		
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 4; j++) {
				for (int k = j + 1; k < 4; k++) {
					for (int l = k + 1; l < 4; l++) {
						int sum = dd[i] + dd[j] + dd[k] + dd[l];
						if (Math.abs(sum - ok) < diff) {
							index[0] = 1; index[1] = 1; index[2] = 1; index[3] = 1;
							diff = Math.abs(sum - ok);
						}
						sum = dd[i] + dd[l];
						if (Math.abs(sum - ok) < diff) {
							index[0] = 1; index[1] = 0; index[2] = 0; index[3] = 1;
							diff = Math.abs(sum - ok);
						}
						sum = dd[j] + dd[l];
						if (Math.abs(sum - ok) < diff) {
							index[0] = 0; index[1] = 1; index[2] = 0; index[3] = 1;
							diff = Math.abs(sum - ok);
						}
						sum = dd[k] + dd[l];
						if (Math.abs(sum - ok) < diff) {
							index[0] = 0; index[1] = 0; index[2] = 1; index[3] = 1;
							diff = Math.abs(sum - ok);
						}
						sum = dd[l];
						if (Math.abs(sum - ok) < diff) {
							index[0] = 0; index[1] = 0; index[2] = 0; index[3] = 1;
							diff = Math.abs(sum - ok);
						}
					}
					int sum = dd[i] + dd[j] + dd[k];
					if (Math.abs(sum - ok) < diff) {
						index[0] = 1; index[1] = 1; index[2] = 1; index[3] = 0;
						diff = Math.abs(sum - ok);
					}
					sum = dd[i] + dd[k];
					if (Math.abs(sum - ok) < diff) {
						index[0] = 1; index[1] = 0; index[2] = 1; index[3] = 0;
						diff = Math.abs(sum - ok);
					}
					sum = dd[j] + dd[k];
					if (Math.abs(sum - ok) < diff) {
						index[0] = 0; index[1] = 1; index[2] = 1; index[3] = 0;
						diff = Math.abs(sum - ok);
					}	
					sum = dd[k];
					if (Math.abs(sum - ok) < diff) {
						index[0] = 0; index[1] = 0; index[2] = 1; index[3] = 0;
						diff = Math.abs(sum - ok);
					}
				}
				int sum = dd[i] + dd[j];
				if (Math.abs(sum - ok) < diff) {
					index[0] = 1; index[1] = 1; index[2] = 0; index[3] = 0;
					diff = Math.abs(sum - ok);
				}
				sum = dd[j];
				if (Math.abs(sum - ok) < diff) {
					index[0] = 0; index[1] = 1; index[2] = 0; index[3] = 0;
					diff = Math.abs(sum - ok);
				}
			}
			int sum = dd[i];
			if (Math.abs(sum - ok) < diff) {
				index[0] = 1; index[1] = 0; index[2] = 0; index[3] = 0;
				diff = Math.abs(sum - ok);
			}
		}
		String res = "";
		for (int i = 0; i < 4; i++) res += index[i];
		return res;
	}

	static String decimalToBinary(String str) {
		if (str == null)
			return "ERROR";
		str = str.trim();
		if (validateString(str) == false) {
			return "ERROR";
		}
		String[] ss = str.split("[.]");
		//System.out.println(ss[0] + "   " + ss[1]);
		String beforeDecimal = getBeforeDecimal(ss[0]);
		String afterDecimal = "";
		if (ss.length == 1) {
			afterDecimal = "0000";
		} else {
			afterDecimal = calculateAfterDecimal(ss[1]);
		}
		return beforeDecimal + "." + afterDecimal;
	}

	public static void main(String[] args) {
		Scanner ss = new Scanner(System.in);
		String str = ss.nextLine();
		str = decimalToBinary(str);
		System.out.println(str);		
	}
}
