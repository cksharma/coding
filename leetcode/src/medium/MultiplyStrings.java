package medium;

import java.math.BigInteger;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        BigInteger b1 = new BigInteger(num1);
        BigInteger b2 = new BigInteger(num2);
        return b1.multiply(b2).toString();
    }
    public static void main(String[] args) {
    	MultiplyStrings sol = new MultiplyStrings();
    	System.out.println(sol.multiply("12", "12"));
	}
}
