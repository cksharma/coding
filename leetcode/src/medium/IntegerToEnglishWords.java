package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cksharma on 9/2/15.
 */
public class IntegerToEnglishWords {
    private static Map<Integer, String> numMap = new HashMap<>();
    static {
                                    numMap.put(10, "Ten");
        numMap.put(1, "One");       numMap.put(11, "Eleven");
        numMap.put(2, "Two");       numMap.put(12, "Twelve");
        numMap.put(3, "Three");     numMap.put(13, "Thirteen");
        numMap.put(4, "Four");      numMap.put(14, "Fourteen");
        numMap.put(5, "Five");      numMap.put(15, "Fifteen");
        numMap.put(6, "Six");       numMap.put(16, "Sixteen");
        numMap.put(7, "Seven");     numMap.put(17, "Seventeen");
        numMap.put(8, "Eight");     numMap.put(18, "Eighteen");
        numMap.put(9, "Nine");      numMap.put(19, "Nineteen");

        numMap.put(20, "Twenty");
        numMap.put(30, "Thirty");
        numMap.put(40, "Forty");
        numMap.put(50, "Fifty");
        numMap.put(60, "Sixty");
        numMap.put(70, "Seventy");
        numMap.put(80, "Eighty");
        numMap.put(90, "Ninety");

        numMap.put(100, "Hundred");
        numMap.put(1000, "Thousand");
        numMap.put(1000000, "Million");
        numMap.put(1000000000, "Billion");
    }

    private String calculateInHundreds(int num) {
        if (num == 0) return "";
        String res = "";
        int ltwo = num % 100;
        if (numMap.containsKey(ltwo)) {
            res += numMap.get(ltwo);
        } else if (ltwo > 0){
            res += numMap.get(ltwo / 10 * 10) + " " + numMap.get(ltwo % 10);
        }
        num /= 100;
        if (num > 0) {
            res = numMap.get(num % 10) + " Hundred " + res;
        }
        return res;
    }


    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String ans = calculateInHundreds(num % 1000);
        num /= 1000;
        if ( num > 0 ) {
            ans = calculateInHundreds(num % 1000) + (num % 1000 != 0 ? " Thousand " : "") + ans;
        }
        num /= 1000;
        if (num > 0) {
            ans = calculateInHundreds(num % 1000) + (num % 1000 != 0 ? " Million " : "") + ans;
        }
        num /= 1000;
        if (num > 0) {
            ans = numMap.get(num % 10) + " Billion " + ans;
        }
        ans = formatString(ans);
        return ans;
    }

    private String formatString(String ans) {
        StringBuilder sb = new StringBuilder();
        sb.append(ans.charAt(0));

        for (int i = 1; i < ans.length(); i++) {
            if (ans.charAt(i) == ' ' && ans.charAt(i - 1) == ' ') continue;
            sb.append(ans.charAt(i));
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        IntegerToEnglishWords sol = new IntegerToEnglishWords();
        System.out.println(sol.numberToWords(100));
        System.out.println(sol.numberToWords(1000));
        System.out.println(sol.numberToWords(10000));
        System.out.println(sol.numberToWords(100000));
        System.out.println(sol.numberToWords(1000000));
        System.out.println(sol.numberToWords(10000000));
        System.out.println(sol.numberToWords(123));
        System.out.println(sol.numberToWords(12345));
        System.out.println(sol.numberToWords(12345000));
        System.out.println(sol.numberToWords(1234567));
        System.out.println(sol.numberToWords(1234567890));
    }
}
