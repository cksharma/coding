package medium;

public class FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator_, int denominator_) {
        boolean positive = 1. * numerator_ / denominator_ >= 0;


        long numerator = Math.abs((long)numerator_);
        long denominator = Math.abs(denominator_);
        if (numerator % denominator == 0) {
            return positive ? numerator / denominator + "" : "-" + numerator / denominator + "";
        }

        boolean[] visited = new boolean[11];
        String ss = "";
        int remindar = (int)(numerator % denominator);
        boolean flag = false;
        //visited[remindar] = true;
        while (remindar != 0) {
            remindar *= 10;
            int was = 0;
            while (remindar < denominator && flag == false) {
                remindar *= 10;
                ss = ss + "0";
                visited[0] = true; was = 1;
            }
            flag = (was == 1);
            if (visited[(int)(remindar / denominator)]) {
                int Q = (int)(remindar / denominator);
                int index = ss.indexOf(Q + "");
                ss = ss.substring(0, index) + "(" + ss.substring(index) + ")";
                break;
            }
            visited[(int)(remindar / denominator)] = true;

            ss += remindar / denominator;
            remindar %= denominator;

        }
        String ans = numerator / denominator + "." + ss;
        return positive ? ans : "-" + ans;
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal sol = new FractionToRecurringDecimal();
        /*System.out.println(sol.fractionToDecimal(1, 2));
        System.out.println(sol.fractionToDecimal(2, 1));
        System.out.println(sol.fractionToDecimal(2, 3));
        System.out.println(sol.fractionToDecimal(22, 7));
        System.out.println(sol.fractionToDecimal(1, 90));
        System.out.println(sol.fractionToDecimal(1, 6));
        System.out.println(sol.fractionToDecimal(-50, 8));
        System.out.println(sol.fractionToDecimal(1, 214748364));*/
        System.out.println(sol.fractionToDecimal(-2147483648, -10));
        System.out.println(sol.fractionToDecimal(1, 99));
    }
}
